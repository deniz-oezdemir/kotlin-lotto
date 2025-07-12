package model

import view.ErrorMessage

@JvmInline
value class TicketCount(val value: Int) {
    init {
        require(value >= 0) { ErrorMessage.ERROR_INVALID_AMOUNT.message }
    }

    override fun toString(): String = value.toString()
}
