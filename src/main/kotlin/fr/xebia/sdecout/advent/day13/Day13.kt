package fr.xebia.sdecout.advent.day13

import java.nio.file.Paths

fun main() {

    val inputFile = Paths.get("src/main/resources/day13/puzzle-input.txt")

    val answer = BusDepartureSequences(inputFile).findEarliestTimestampWithOffsetsMatchingPositionsInTheList()

    println("Answer: $answer")

}
