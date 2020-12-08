package fr.xebia.sdecout.advent.day8

import java.nio.file.Paths

fun main() {

    val inputFile = Paths.get("src/main/resources/day8/puzzle-input.txt")

    val initialProgram = Program(inputFile)
    val accumulator = ProgramFixer(initialProgram).fix()?.accumulator

    println("Answer: $accumulator")

}
