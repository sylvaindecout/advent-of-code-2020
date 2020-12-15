package fr.xebia.sdecout.advent.day15

fun main() {

    val input = listOf(11, 0, 1, 10, 5, 19)

    val player = Game(input)
    player.playTurns(30_000_000)

    println("Answer: ${player.lastSpokenNumber}")

}
