package model

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class LottoTest {
    private fun dummyTickets() = Tickets() // creates empty ticket list

    private fun dummyManualAmount() = 0

    @Test
    fun `valid purchase amount which is unit`() {
        assertDoesNotThrow {
            val lotto = Lotto(1000, dummyManualAmount(), dummyTickets())
            assertEquals(1, lotto.numberOfTickets)
        }
    }

    @Test
    fun `valid purchase amount above unit`() {
        assertDoesNotThrow {
            val lotto = Lotto(15000, dummyManualAmount(), dummyTickets())
            assertEquals(15, lotto.numberOfTickets)
        }
    }

    @Test
    fun `valid ticket size`() {
        val lotto = Lotto(15000, dummyManualAmount(), dummyTickets())
        val ticket = lotto.fillTicket()
        assertEquals(6, ticket.toList().size)
    }

    @Test
    fun `valid non-duplicate ticket numbers`() {
        val lotto = Lotto(15000, dummyManualAmount(), dummyTickets())
        val ticket = lotto.fillTicket()
        assertEquals(6, ticket.toList().toSet().size)
    }

    @Test
    fun `ticket numbers are in valid range 1 to 45`() {
        val lotto = Lotto(1000, dummyManualAmount(), dummyTickets())
        val ticket = lotto.fillTicket()

        for (number in ticket.toList()) {
            assertTrue(number in 1..45, "Number $number is not in valid range 1-45")
        }
    }

    @Test
    fun `lotto ticket includes manual and automatic tickets`() {
        val manualTicket = Ticket(listOf(1, 2, 3, 4, 5, 6))
        val manualTickets =
            Tickets().apply {
                add(manualTicket)
            }

        val lotto =
            Lotto(
                purchaseAmount = 3000,
                manualTicketAmount = 1,
                manualTickets = manualTickets,
            )

        assertEquals(3, lotto.numberOfTickets)
        assertEquals(1, lotto.manualTicketAmount)
    }
}
