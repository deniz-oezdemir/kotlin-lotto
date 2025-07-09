package model

object Validator {
    fun amountIsValidUnit(amount: Int?): Boolean {
        if (amount == null) return false
        if (amount % Lotto.PURCHASE_AMOUNT_UNIT == 0) return true
        return false
    }
}
