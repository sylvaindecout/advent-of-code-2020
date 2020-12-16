package fr.xebia.sdecout.advent.day16

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.nio.file.Paths

@Tag("Integration")
class TicketTranslationTest {

    @Test
    fun `should resolve ticket scanning error rate`() {
        val input = Paths.get("src/main/resources/day16/example.txt")

        val answer = TicketTranslation.parse(input).ticketScanningErrorRate

        assertThat(answer).isEqualTo(71)
    }

    @Test
    fun `should filter valid nearby tickets`() {
        val input = Paths.get("src/main/resources/day16/example.txt")

        val answer = TicketTranslation.parse(input).validNearbyTickets

        assertThat(answer).containsExactly(
            UnresolvedTicket(listOf(7, 3, 47))
        )
    }

    @Test
    fun `should resolve your ticket`() {
        val input = Paths.get("src/main/resources/day16/example-2.txt")

        val answer = TicketTranslation.parse(input).resolveYourTicket()

        assertThat(answer).isEqualTo(Ticket(mapOf(
            Pair("class", 12),
            Pair("row", 11),
            Pair("seat", 13)
        )))
    }

}
