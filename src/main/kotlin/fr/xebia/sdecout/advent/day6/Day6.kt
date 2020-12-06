package fr.xebia.sdecout.advent.day6

import java.nio.file.Paths

fun main() {

    val inputFile = Paths.get("src/main/resources/day6/puzzle-input.txt")
    val positiveAnswersByGroup = CustomsDeclarationForms(inputFile).countPositiveAnswersByGroup()
    println("Answer: $positiveAnswersByGroup")

}
