package model

class Tickets() {
    val ticketList = mutableListOf<Ticket>()

    fun add(ticket: Ticket) {
        ticketList.add(ticket)
    }

    override fun toString(): String = ticketList.joinToString("\n")
}
