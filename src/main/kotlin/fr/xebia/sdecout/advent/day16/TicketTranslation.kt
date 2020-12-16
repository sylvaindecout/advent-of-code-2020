package fr.xebia.sdecout.advent.day16

import java.nio.file.Files.readAllLines
import java.nio.file.Path

data class TicketTranslation(
    val rules: List<Rule>,
    val yourTicket: UnresolvedTicket,
    val nearbyTickets: List<UnresolvedTicket>
) {

    val validNearbyTickets: List<UnresolvedTicket> by lazy {
        nearbyTickets.filter { ticket ->
            ticket.values.none { value ->
                rules.none { it.validate(value) }
            }
        }
    }

    val ticketScanningErrorRate: Int by lazy {
        nearbyTickets.flatMap { it.values }
            .filter { value ->
                rules.none { it.validate(value) }
            }.sum()
    }

    fun resolveYourTicket(): Ticket {
        val orderedFields: Map<Int, String> = rules.indices
            .map { it to resolveCompliantFields(it) }
            .toMap()
            .let { clearIncompatibilities(it) }
            .mapValues { it.value.first() }
        return yourTicket.values.indices
            .map { Pair(orderedFields.getValue(it), yourTicket.values[it]) }
            .toMap()
            .let { Ticket(it) }
    }

    private fun resolveCompliantFields(fieldIndex: Int): List<String> {
        return rules
            .filter { rule -> validNearbyTickets.all { ticket -> rule.validate(ticket.values[fieldIndex]) } }
            .map { it.field }
    }

    private fun clearIncompatibilities(possibilities: Map<Int, List<String>>): Map<Int, List<String>> {
        val okValues = possibilities.values.filter { it.size == 1 }.map { it[0] }
        return possibilities.toMutableMap()
            .map { Pair(it.key, if (it.value.size > 1) it.value - okValues else it.value) }
            .toMap()
            .let { if (possibilities == it) it else clearIncompatibilities(it) }
    }

    companion object {
        fun parse(inputFile: Path) = readAllLines(inputFile).let { lines ->
            TicketTranslation(
                rules = (0 until lines.indexOf("your ticket:") - 1)
                    .map { lines[it] }
                    .map { Rule.parse(it) },
                yourTicket = (lines.indexOf("your ticket:") + 1)
                    .let { lines[it] }
                    .let { UnresolvedTicket.parse(it) },
                nearbyTickets = (lines.indexOf("nearby tickets:") + 1 until lines.size)
                    .map { lines[it] }
                    .map { UnresolvedTicket.parse(it) }
            )
        }
    }

}
