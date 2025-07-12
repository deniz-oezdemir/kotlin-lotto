package model

class Lotto(
    val purchaseAmount: Int,
    val manualTickets: Tickets,
) {
    val numberOfTickets: Int = purchaseAmount / PURCHASE_AMOUNT_UNIT
    var tickets = manualTickets

    fun generateTickets(manualTicketAmount: TicketCount) {
        val ticketsToGenerate = numberOfTickets - manualTicketAmount.value
        repeat(ticketsToGenerate) {
            tickets.add(fillTicket())
        }
    }

    fun fillTicket(): Ticket {
        val randomNumbers =
            (TICKET_NUMBER_MINIMUM..TICKET_NUMBER_MAXIMUM)
                .shuffled()
                .take(TICKET_LENGTH)
        return Ticket(randomNumbers)
    }

    companion object {
        const val PURCHASE_AMOUNT_UNIT = 1000
        const val TICKET_LENGTH = 6
        const val TICKET_NUMBER_MINIMUM = 1
        const val TICKET_NUMBER_MAXIMUM = 45
    }
}
