package fr.xebia.sdecout.advent.day1

import java.nio.file.Paths

fun main() {

    val inputFile = Paths.get("src/main/resources/day1/puzzle-input.txt")

    val theRightCombination = ListOfNumbers(inputFile).findCombinationSummingTo(2020)
    val product = theRightCombination.first * theRightCombination.second * theRightCombination.third

    println("Answer: $product")

}
