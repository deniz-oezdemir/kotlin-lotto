package view

import model.Lotto
import model.LottoNumber
import model.TicketCount
import model.Tickets
import model.UserBonusNumber

class OutputView {
    fun displayAmount(amount: Int) {
        println("$amount\n")
    }

    fun displayNumberOfLottoTickets(
        lotto: Lotto,
        manualTickets: TicketCount,
    ) {
        println(
            "You have purchased ${manualTickets.value} manual and " +
                "${lotto.numberOfTickets - manualTickets.value} automatic tickets.",
        )
    }

    fun displayTickets(lotto: Lotto) {
        for (i in 0 until lotto.numberOfTickets) {
            println(lotto.tickets.ticketList[i])
        }
        println()
    }

    fun displayManualTickets(manualTickets: Tickets) {
        manualTickets.ticketList.forEach {
            println(it.toCompactString())
        }
        println()
    }

    fun displayTicketNumbers(numbers: List<LottoNumber>) {
        for (number in numbers) {
            if (numbers.last() != number) {
                print("$number, ")
            } else {
                println("$number")
            }
        }
    }

    fun displayBonusNumber(bonusNumber: UserBonusNumber) {
        println("$bonusNumber\n")
    }

    fun displayMatchResults(results: List<Int>) {
        println("Winning Statistics")
        println("------------------")
        println("3 Matches (5,000 KRW) - ${results[4]} tickets")
        println("4 Matches (50,000 KRW) - ${results[3]}  tickets")
        println("5 Matches (1,500,000 KRW) - ${results[2]}  tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) - ${results[1]}  tickets")
        println("6 Matches (2,000,000,000 KRW) - ${results[0]}  tickets")
    }

    fun displayWinningStatistic(winningStatistic: Float) {
        println("Total return rate is ${"%.2f".format(winningStatistic)} (A rate below 1 means a loss)\n")
    }
}
