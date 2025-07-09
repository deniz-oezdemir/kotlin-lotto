package controller

import model.Lotto
import model.Statistics
import model.UserBonusNumber
import model.UserMainNumbers
import model.WinningNumbers
import view.InputView
import view.OutputView

class Controller {
    fun run(
        inputView: InputView,
        outputView: OutputView,
    ) {
        val lotto = handleLottoPurchase(inputView, outputView)
        val (mainNumbers, bonusNumber) = handleWinningNumbers(inputView, outputView)
        val winningNumbers = WinningNumbers(mainNumbers, bonusNumber)
        handleResultDisplay(lotto, winningNumbers, outputView)
    }

    private fun handleLottoPurchase(
        inputView: InputView,
        outputView: OutputView,
    ): Lotto {
        val purchaseAmount = inputView.getPurchaseAmount()
        outputView.displayAmount(purchaseAmount)
        val manualTicketsAmount = inputView.getManualTicketsAmount()
        outputView.displayAmount(manualTicketsAmount)
        val manualTickets = inputView.getManualTickets(manualTicketsAmount)
        outputView.displayManualTickets(manualTickets)
        val lotto = Lotto(purchaseAmount, manualTicketsAmount, manualTickets)
        outputView.displayNumberOfLottoTickets(lotto)
        lotto.generateTickets()
        outputView.displayTickets(lotto)
        return lotto
    }

    private fun handleWinningNumbers(
        inputView: InputView,
        outputView: OutputView,
    ): Pair<UserMainNumbers, UserBonusNumber> {
        val userMainNumbers = inputView.getWinningNumbers()
        outputView.displayTicketNumbers(userMainNumbers.numbers)
        val bonusNumber = inputView.getBonusNumber(userMainNumbers)
        outputView.displayBonusNumber(bonusNumber)
        return Pair(userMainNumbers, bonusNumber)
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
