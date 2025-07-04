package view

import model.Lotto

class InputView {
    private fun readLineOrRetry(prompt: String): String {
        while (true) {
            print(prompt)
            val input = readLine()
            if (input != null) {
                return input
            } else {
                println(ErrorMessage.RETRY_INPUT_MESSAGE)
            }
        }
    }

    private fun parsePurchaseAmount(input: String): Int? {
        return input.toIntOrNull()
    }

    fun getPurchaseAmount(): Int {
        while (true) {
            val input = readLineOrRetry(ErrorMessage.GET_PURCHASE_AMOUNT.toString())
            val amount = parsePurchaseAmount(input)
            if (amount != null) {
                return amount
            } else {
                println(ErrorMessage.INVALID_INPUT_MESSAGE)
            }
        }
    }

    private fun convertWinningNumbers(input: String): List<Int> {
        return try {
            input.split(",")
                .map { it.trim().toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessage.ERROR_INVALID_DIGITS.toString())
        }
    }

    fun isValidRange(numbers: List<Int>): Boolean {
        return numbers.all { it in 1..45 }
    }

    fun hasNoDuplicates(numbers: List<Int>): Boolean {
        return numbers.toSet().size == numbers.size
    }

    fun hasProperSize(numbers: List<Int>): Boolean {
        return numbers.size == Lotto.TICKET_LENGTH
    }

    fun validateWinningNumbers(winningNumbers: List<Int>) {
        require(isValidRange(winningNumbers)) { ErrorMessage.ERROR_BONUS_RANGE }
        require(hasNoDuplicates(winningNumbers)) { ErrorMessage.ERROR_DUPLICATE }
        require(hasProperSize(winningNumbers)) { ErrorMessage.ERROR_NUMBERSET_SIZE }
    }

    fun getWinningNumbers(): List<Int> {
        while (true) {
            val input = readLineOrRetry(ErrorMessage.GET_WINNING_NUMBERS.toString())
            try {
                val winningNumbers = convertWinningNumbers(input)
                validateWinningNumbers(winningNumbers)
                return winningNumbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun validateBonusNumber(
        bonusNumber: Int,
        winningNumbers: List<Int>,
    ) {
        require(bonusNumber in Lotto.TICKET_NUMBER_MINIMUM..Lotto.TICKET_NUMBER_MAXIMUM) { ErrorMessage.ERROR_BONUS_RANGE }
        require(!winningNumbers.contains(bonusNumber)) { ErrorMessage.ERROR_DUPLICATE }
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            val input = readLineOrRetry(ErrorMessage.GET_BONUS_NUMBERS.toString())
            try {
                val bonusNumber = input.toInt()
                validateBonusNumber(bonusNumber, winningNumbers)
                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
