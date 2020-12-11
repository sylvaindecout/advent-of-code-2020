package fr.xebia.sdecout.advent.day11

import fr.xebia.sdecout.advent.day11.Mode.NEXT_VISIBLE_SEATS
import java.nio.file.Paths

fun main() {

    val inputFile = Paths.get("src/main/resources/day11/puzzle-input.txt")

    val nbOccupiedSeats = Seating(inputFile).updateUntilStabilized(mode = NEXT_VISIBLE_SEATS, tolerance = 5).countOccupiedSeats()

    println("Answer: $nbOccupiedSeats")

}
