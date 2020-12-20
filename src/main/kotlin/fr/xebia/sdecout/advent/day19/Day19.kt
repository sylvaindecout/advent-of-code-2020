package fr.xebia.sdecout.advent.day19

import java.nio.file.Paths

fun main() {

    val input = Paths.get("src/main/resources/day19/puzzle-input.txt")

    val monsterMessages = MonsterMessages.parse(input).fix()
    val nbValidMessages = monsterMessages.validMessages.count()

    println("Answer: $nbValidMessages")

}
