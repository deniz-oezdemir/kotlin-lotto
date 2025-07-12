package view

import model.Ticket
import model.TicketCount
import model.Tickets
import model.UserBonusNumber
import model.UserMainNumbers
import model.Validator

class InputView {
    private fun readLineOrRetry(prompt: String): String {
        while (true) {
            print(prompt)
            val input = readlnOrNull()
            if (input != null) {
                return input
            } else {
                println(PromptMessage.RETRY_INPUT_MESSAGE)
            }
        }
    }

    private fun parseTicketAmount(input: String): Int {
        val input = input.toIntOrNull()
        if (input != null) {
            return input
        }
        throw IllegalArgumentException()
    }

    fun getManualTicketsAmount(): TicketCount {
        while (true) {
            val input = readLineOrRetry(PromptMessage.GET_MANUAL_AMOUNT.message)
            try {
                val amount = parseTicketAmount(input)
                return TicketCount(amount)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getManualNumbers(): List<Int> {
        while (true) {
            val input = readLineOrRetry("")
            try {
                return convertNumbers(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getManualTickets(manualTicketsAmount: TicketCount): Tickets {
        val manualTickets = Tickets()
        var count = 0
        println(PromptMessage.GET_MANUAL_NUMBERS.message)
        while (count < manualTicketsAmount.value) {
            val input = getManualNumbers()
            try {
                manualTickets.add(Ticket(input))
                count += 1
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        return manualTickets
    }

    private fun parsePurchaseAmount(input: String): Int? {
        return input.toIntOrNull()
    }

    fun getPurchaseAmount(): Int {
        while (true) {
            val input = readLineOrRetry(PromptMessage.GET_PURCHASE_AMOUNT.message)
            val amount = parsePurchaseAmount(input)
            if (amount != null && Validator.amountIsValidUnit(amount)) {
                return amount
            } else {
                println(ErrorMessage.ERROR_INVALID_UNIT.message)
            }
        }
    }

    private fun convertNumbers(input: String): List<Int> {
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
                val winningNumbers = convertNumbers(input)
                return UserMainNumbers.of(winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getBonusNumber(winningNumbers: UserMainNumbers): UserBonusNumber {
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
