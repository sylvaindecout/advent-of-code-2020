package fr.xebia.sdecout.advent.day4

import java.nio.file.Paths

fun main() {

    val inputFile = Paths.get("src/main/resources/day4/puzzle-input.txt")
    val nbValidPassports = PassportFileValidator(inputFile).resolveNbValidPassports()
    println("Answer: $nbValidPassports")

}
