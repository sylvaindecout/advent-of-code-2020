package fr.xebia.sdecout.advent.day10

import java.nio.file.Paths

fun main() {

    val inputFile = Paths.get("src/main/resources/day10/puzzle-input.txt")

    val product = AdapterPathBuilder(inputFile).countPossibleArrangements()

    println("Answer: $product")

}
