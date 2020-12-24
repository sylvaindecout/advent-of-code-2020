package fr.xebia.sdecout.advent.day24

import java.nio.file.Paths

fun main() {

    val input = Paths.get("src/main/resources/day24/puzzle-input.txt")

    val initialLayout = LobbyLayout(input).executeInstructions()
    println("Answer (part 1): ${initialLayout.blackTiles.count()}")

    val finalLayout = initialLayout.applyDailyRules(nbDays = 100)
    println("Answer (part 2): ${finalLayout.blackTiles.count()}")

}
