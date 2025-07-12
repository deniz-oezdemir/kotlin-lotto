package model

import view.ErrorMessage

class UserMainNumbers private constructor(
    val numbers: List<LottoNumber>,
) {
    companion object {
        fun of(rawNumbers: List<Int>): UserMainNumbers {
            require(rawNumbers.size == Lotto.TICKET_LENGTH) {
                ErrorMessage.ERROR_NUMBERSET_SIZE.message
            }
            require(rawNumbers.toSet().size == rawNumbers.size) {
                ErrorMessage.ERROR_DUPLICATE.message
            }

            val lottoNumbers = rawNumbers.map { LottoNumber(it) }
            return UserMainNumbers(lottoNumbers)
        }
    }

    fun asIntList(): List<Int> = numbers.map { it.number }

    override fun toString(): String =
        numbers.sortedBy { it.number }
            .joinToString(", ", prefix = "[", postfix = "]")
}
