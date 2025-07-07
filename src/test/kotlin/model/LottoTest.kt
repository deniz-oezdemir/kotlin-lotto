package model

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class LottoTest {
    @Test
    fun `valid purchase amount which is unit`() {
        assertDoesNotThrow {
            val lotto = Lotto(1000)
            assertEquals(1, lotto.numberOfTickets)
        }
    }

    @Test
    fun `valid purchase amount above unit`() {
        assertDoesNotThrow {
            val lotto = Lotto(15000)
            assertEquals(15, lotto.numberOfTickets)
        }
    }

    @Test
    fun `valid ticket size`() {
        val lotto = Lotto(15000)
        val ticket = lotto.fillTicket()
        assertEquals(6, ticket.toList().size)
    }

    @Test
    fun `valid non-duplicate ticket numbers`() {
        val lotto = Lotto(15000)
        val ticket = lotto.fillTicket()
        assertEquals(6, ticket.toList().toSet().size)
    }

    @Test
    fun `ticket numbers are in valid range 1 to 45`() {
        val lotto = Lotto(1000)
        val ticket = lotto.fillTicket()

        for (number in ticket.toList()) {
            assertTrue(number in 1..45, "Number $number is not in valid range 1-45")
        }
    }
}
