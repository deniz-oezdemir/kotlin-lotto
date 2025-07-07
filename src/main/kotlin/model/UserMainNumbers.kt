package model

import view.ErrorMessage

class UserMainNumbers private constructor(
    val numbers: List<Int>,
) {
    companion object {
        fun of(rawNumbers: List<Int>): UserMainNumbers {
            require(rawNumbers.size == Lotto.TICKET_LENGTH) { ErrorMessage.ERROR_NUMBERSET_SIZE.message }
            require(rawNumbers.toSet().size == rawNumbers.size) { ErrorMessage.ERROR_DUPLICATE.message }
            require(
                rawNumbers.all { it in Lotto.TICKET_NUMBER_MINIMUM..Lotto.TICKET_NUMBER_MAXIMUM },
            ) { ErrorMessage.ERROR_BONUS_RANGE.message }
            return UserMainNumbers(rawNumbers)
        }
    }
}
