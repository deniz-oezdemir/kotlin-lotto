package model

import view.ErrorMessage

data class UserBonusNumber(val bonusNumber: LottoNumber) {
    companion object {
        fun of(
            number: Int,
            winningNumbers: UserMainNumbers,
        ): UserBonusNumber {
            val lottoNumber = LottoNumber(number)
            require(lottoNumber !in winningNumbers.numbers) {
                ErrorMessage.ERROR_DUPLICATE.message
            }
            return UserBonusNumber(lottoNumber)
        }
    }

    fun value(): Int = bonusNumber.number

    override fun toString(): String = bonusNumber.toString()
}
