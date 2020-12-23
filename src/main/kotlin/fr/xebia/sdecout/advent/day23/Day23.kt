package fr.xebia.sdecout.advent.day23

fun main() {

    val input = "916438275"

    val answer1 = Game(
        input = input,
        nbCups = 9,
        nbMoves = 100
    ).play().drop(1).joinToString("")
    println("Answer (part 1): $answer1")

    val answer2 = Game(
        input = input,
        nbCups = 1_000_000,
        nbMoves = 10_000_000
    ).play().take(3).fold(1L) { acc, cup -> acc * cup.label }
    println("Answer (part 2): $answer2")

}
