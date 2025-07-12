package controller

import model.Lotto
import model.Statistics
import model.WinningNumbers
import view.InputView
import view.OutputView

class Controller {
    fun run(
        inputView: InputView,
        outputView: OutputView,
    ) {
        val lotto = handleLottoPurchase(inputView, outputView)
        val winningNumbers = handleWinningNumbers(inputView, outputView)
        handleResultDisplay(lotto, winningNumbers, outputView)
    }

    private fun handleLottoPurchase(
        inputView: InputView,
        outputView: OutputView,
    ): Lotto {
        val purchaseAmount = inputView.getPurchaseAmount()
        outputView.displayAmount(purchaseAmount)
        val manualTicketsAmount = inputView.getManualTicketsAmount()
        outputView.displayAmount(manualTicketsAmount.value)
        val manualTickets = inputView.getManualTickets(manualTicketsAmount)
        outputView.displayManualTickets(manualTickets)
        val lotto = Lotto(purchaseAmount, manualTickets)
        outputView.displayNumberOfLottoTickets(lotto, manualTicketsAmount)
        lotto.generateTickets(manualTicketsAmount)
        outputView.displayTickets(lotto)
        return lotto
    }

    private fun handleWinningNumbers(
        inputView: InputView,
        outputView: OutputView,
    ): WinningNumbers {
        val userMainNumbers = inputView.getWinningNumbers()
        outputView.displayTicketNumbers(userMainNumbers.numbers)
        val bonusNumber = inputView.getBonusNumber(userMainNumbers)
        outputView.displayBonusNumber(bonusNumber)
        return WinningNumbers(userMainNumbers, bonusNumber)
    }

    private fun handleResultDisplay(
        lotto: Lotto,
        winningNumbers: WinningNumbers,
        outputView: OutputView,
    ) {
        val matchResult = Statistics.calculateMatchResults(lotto, winningNumbers)
        outputView.displayMatchResults(matchResult)
        val winningStatistic = Statistics.calculateWinningStatistic(lotto.purchaseAmount, matchResult)
        outputView.displayWinningStatistic(winningStatistic)
    }
}
