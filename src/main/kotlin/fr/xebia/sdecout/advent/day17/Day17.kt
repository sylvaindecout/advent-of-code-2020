package fr.xebia.sdecout.advent.day17

import fr.xebia.sdecout.advent.day17.Mode.FOUR_D
import java.nio.file.Paths

fun main() {

    val input = Paths.get("src/main/resources/day17/puzzle-input.txt")

    val nbActiveCubes = (0 until 6)
        .fold(PocketDimension.init(input, FOUR_D)) { dimension, _ -> dimension.simulateOneCycle() }
        .activeCubes.count()

    println("Answer: $nbActiveCubes")

}
