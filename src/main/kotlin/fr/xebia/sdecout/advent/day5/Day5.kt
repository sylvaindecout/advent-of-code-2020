package fr.xebia.sdecout.advent.day5

import java.nio.file.Paths

fun main() {

    val inputFile = Paths.get("src/main/resources/day5/puzzle-input.txt")
    val unoccupiedSeatId = SeatFinder(inputFile).findUnoccupiedSeat().getSeatId()
    println("Answer: $unoccupiedSeatId")

}
