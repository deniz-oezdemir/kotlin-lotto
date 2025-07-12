package view

import model.Lotto

enum class ErrorMessage(val message: String) {
    ERROR_INVALID_UNIT("[ERROR] Purchase amount must be divisible by 1000."),
    ERROR_INVALID_AMOUNT("[ERROR] Manual ticket amount must be a non-negative integer."),
    ERROR_INVALID_DIGITS("[ERROR] Winning numbers must be valid digits."),
    ERROR_RANGE("[ERROR] Number must be between ${Lotto.TICKET_NUMBER_MINIMUM} and ${Lotto.TICKET_NUMBER_MAXIMUM}."),
    ERROR_DUPLICATE("[ERROR] Numbers can't be duplicates."),
    ERROR_NUMBERSET_SIZE("[ERROR] There must be ${Lotto.TICKET_LENGTH} numbers."),
}
