package fr.xebia.sdecout.advent.day12

import fr.xebia.sdecout.advent.day12.part2.Navigation
import java.nio.file.Paths

fun main() {

    val inputFile = Paths.get("src/main/resources/day12/puzzle-input.txt")

    val finalPosition = Navigation(inputFile).applyAllInstructions()

    println("Answer: ${finalPosition.manhattanDistance}")

}
