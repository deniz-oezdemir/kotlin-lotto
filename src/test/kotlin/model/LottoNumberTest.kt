package model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {
    @Test
    fun `creates LottoNumber for value inside valid range`() {
        val lottoNumber = LottoNumber(1)
        assertEquals(1, lottoNumber.number)
        assertEquals("1", lottoNumber.toString())
    }

    @Test
    fun `throws IllegalArgumentException for value below minimum`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(0)
        }
    }

    @Test
    fun `throws IllegalArgumentException for value above maximum`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(46)
        }
    }
}
