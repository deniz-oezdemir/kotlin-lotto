package view

import model.Lotto

enum class ErrorMessage(val message: String) {
    GET_PURCHASE_AMOUNT("Please enter the purchase amount.\n"),
    GET_WINNING_NUMBERS("Please enter last week's winning numbers.\n"),
    GET_BONUS_NUMBERS("Please enter last week's bonus number.\n"),
    RETRY_INPUT_MESSAGE("Please enter the input again!"),
    INVALID_INPUT_MESSAGE("[ERROR] The input is invalid!"),
    ERROR_INVALID_DIGITS("[ERROR] Winning numbers must be valid digits."),
    ERROR_BONUS_RANGE("[ERROR] Number must be between ${Lotto.TICKET_NUMBER_MINIMUM} and ${Lotto.TICKET_NUMBER_MAXIMUM}."),
    ERROR_DUPLICATE("[ERROR] Numbers can't be duplicates."),
    ERROR_NUMBERSET_SIZE("[ERROR] There must be ${Lotto.TICKET_LENGTH} numbers."),
    ;

    override fun toString(): String = message
}
