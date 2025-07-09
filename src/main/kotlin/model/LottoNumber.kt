package model

import view.ErrorMessage

data class LottoNumber(val number: Int) {
    init {
        require(number in Lotto.TICKET_NUMBER_MINIMUM..Lotto.TICKET_NUMBER_MAXIMUM) { ErrorMessage.ERROR_RANGE.message }
    }

    override fun toString(): String = number.toString()
}
