package fr.xebia.sdecout.advent.day16

import java.nio.file.Paths

fun main() {

    val input = Paths.get("src/main/resources/day16/puzzle-input.txt")

    val yourTicket: Ticket = TicketTranslation.parse(input).resolveYourTicket()
    val answer = yourTicket.fields
        .filter { it.key.startsWith("departure") }
        .map { it.value }
        .fold(1L) { acc, value -> acc * value }

    println("Answer: $answer")

}
