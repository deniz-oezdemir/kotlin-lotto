package view

enum class PromptMessage(val message: String) {
    GET_PURCHASE_AMOUNT("Please enter the purchase amount.\n"),
    GET_MANUAL_AMOUNT("Enter the number of manual tickets to purchase.\n"),
    GET_MANUAL_NUMBERS("Enter the numbers for manual tickets."),
    GET_WINNING_NUMBERS("Please enter last week's winning numbers.\n"),
    GET_BONUS_NUMBERS("Please enter last week's bonus number.\n"),
    RETRY_INPUT_MESSAGE("Please enter the input again!"),
}
