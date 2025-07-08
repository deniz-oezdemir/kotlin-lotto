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
        val (mainNumbers, bonusNumber) = handleWinningNumbers(inputView, outputView)
        val winningNumbers = WinningNumbers(mainNumbers, bonusNumber)
        handleResultDisplay(lotto, winningNumbers, outputView)
    }

    private fun handleLottoPurchase(
        inputView: InputView,
        outputView: OutputView,
    ): Lotto {
        val purchaseAmount = inputView.getPurchaseAmount()
        val lotto = Lotto(purchaseAmount)
        outputView.displayPurchaseAmount(lotto)
        outputView.displayNumberOfLottoTickets(lotto)
        lotto.generateTickets()
        outputView.displayTickets(lotto)
        return lotto
    }

    private fun handleWinningNumbers(
        inputView: InputView,
        outputView: OutputView,
    ): Pair<List<Int>, Int> {
        val userMainNumbers = inputView.getWinningNumbers()
        outputView.displayWinningNumbers(userMainNumbers.numbers)
        val bonusNumber = inputView.getBonusNumber(userMainNumbers)
        outputView.displayBonusNumber(bonusNumber)
        return Pair(userMainNumbers.numbers, bonusNumber)
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
