package view

import model.Lotto
import model.UserBonusNumber
import model.UserMainNumbers

class InputView {
    private fun readLineOrRetry(prompt: String): String {
        while (true) {
            print(prompt)
            val input = readLine()
            if (input != null) {
                return input
            } else {
                println(PromptMessage.RETRY_INPUT_MESSAGE)
            }
        }
    }

    private fun parsePurchaseAmount(input: String): Int? {
        return input.toIntOrNull()
    }

    fun getPurchaseAmount(): Int {
        while (true) {
            val input = readLineOrRetry(PromptMessage.GET_PURCHASE_AMOUNT.message)
            val amount = parsePurchaseAmount(input)
            if (amount != null && amount % Lotto.PURCHASE_AMOUNT_UNIT == 0) {
                return amount
            } else {
                println(ErrorMessage.ERROR_INVALID_UNIT.message)
            }
        }
    }

    private fun convertWinningNumbers(input: String): List<Int> {
        return try {
            input.split(",")
                .map { it.trim().toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessage.ERROR_INVALID_DIGITS.message)
        }
    }

    fun getWinningNumbers(): UserMainNumbers {
        while (true) {
            val input = readLineOrRetry(PromptMessage.GET_WINNING_NUMBERS.message)
            try {
                val winningNumbers = convertWinningNumbers(input)
                return UserMainNumbers.of(winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getBonusNumber(winningNumbers: UserMainNumbers): Int {
        while (true) {
            val input = readLineOrRetry(PromptMessage.GET_BONUS_NUMBERS.message)
            try {
                val bonus = input.toInt()
                return UserBonusNumber.of(bonus, winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
