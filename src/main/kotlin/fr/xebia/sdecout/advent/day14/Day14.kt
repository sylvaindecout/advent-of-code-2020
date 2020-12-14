package fr.xebia.sdecout.advent.day14

import java.nio.file.Paths

fun main() {

    val inputFile = Paths.get("src/main/resources/day14/puzzle-input.txt")

    val answer = InitializationProgram.V2(inputFile).execute().values.sum()

    println("Answer: $answer")

}
