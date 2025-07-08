package model

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class UserNumbersTest {
    companion object {
        @JvmStatic
        fun invalidMainNumbers() =
            listOf(
                listOf(1, 2, 3, 4, 5, 5),
                listOf(1, 2, 3, 4),
                listOf(0, 1, 2, 3, 4, 5),
            )

        @JvmStatic
        fun invalidBonusNumbers() =
            listOf(
                0,
                46,
                5,
            )
    }

    @ParameterizedTest
    @MethodSource("invalidMainNumbers")
    fun `invalid main numbers throw exception`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            UserMainNumbers.of(numbers)
        }
    }

    @ParameterizedTest
    @MethodSource("invalidBonusNumbers")
    fun `invalid bonus number throws exception`(bonus: Int) {
        val mainNumbers = UserMainNumbers.of(listOf(1, 2, 3, 4, 5, 6))

        assertThrows<IllegalArgumentException> {
            UserBonusNumber.of(bonus, mainNumbers)
        }
    }
}
