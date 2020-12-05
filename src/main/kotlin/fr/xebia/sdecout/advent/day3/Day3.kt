package fr.xebia.sdecout.advent.day3

import java.nio.file.Paths

fun main() {

    val inputFile = Paths.get("src/main/resources/day3/puzzle-input.txt")

    val area = Area(inputFile)
    val nbOfTreesEncountered = listOf(
        Slope({ x -> x + 1 }, { y -> y + 1 }),
        Slope({ x -> x + 3 }, { y -> y + 1 }),
        Slope({ x -> x + 5 }, { y -> y + 1 }),
        Slope({ x -> x + 7 }, { y -> y + 1 }),
        Slope({ x -> x + 1 }, { y -> y + 2 })
    ).map { area.getNbOfTreesEncountered(it) }
    val product: Long = nbOfTreesEncountered.fold(1) { total, item -> total * item }

    println("Answer: $product")

}
