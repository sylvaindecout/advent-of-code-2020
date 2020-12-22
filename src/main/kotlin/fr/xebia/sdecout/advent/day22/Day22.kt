package fr.xebia.sdecout.advent.day22

import java.nio.file.Paths

fun main() {

    val input = Paths.get("src/main/resources/day22/puzzle-input.txt")

    val recursiveCombat = RecursiveCombat(input)
    val answer = recursiveCombat.play().score
    println("Answer: $answer")

}
