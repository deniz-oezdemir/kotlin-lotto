package model

class Ticket(private val values: List<Int>) {
    init {
        require(values.size == Lotto.TICKET_LENGTH) {
            "[ERROR] There must be ${Lotto.TICKET_LENGTH} numbers."
        }
        require(values.distinct().size == values.size) {
            "[ERROR] Numbers can't be duplicates."
        }
        require(values.all { it in Lotto.TICKET_NUMBER_MINIMUM..Lotto.TICKET_NUMBER_MAXIMUM }) {
            "[ERROR] Number must be between ${Lotto.TICKET_NUMBER_MINIMUM} and ${Lotto.TICKET_NUMBER_MAXIMUM}."
        }
    }

    fun toList(): List<Int> = values

    override fun toString(): String {
        return values.sorted().joinToString(", ", prefix = "[", postfix = "]")
    }

    fun toCompactString(): String {
        return values.sorted()
            .joinToString(", ")
    }
}
