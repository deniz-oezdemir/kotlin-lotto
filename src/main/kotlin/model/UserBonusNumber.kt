package model

import view.ErrorMessage

data class UserBonusNumber(val number: Int) {
    companion object {
        fun of(
            number: Int,
            winningNumbers: UserMainNumbers,
        ): Int {
            require(number in Lotto.TICKET_NUMBER_MINIMUM..Lotto.TICKET_NUMBER_MAXIMUM) { ErrorMessage.ERROR_BONUS_RANGE.message }
            require(number !in winningNumbers.numbers) { ErrorMessage.ERROR_DUPLICATE.message }
            return number
        }
    }
}
