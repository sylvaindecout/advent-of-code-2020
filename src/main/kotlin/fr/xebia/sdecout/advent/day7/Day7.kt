package fr.xebia.sdecout.advent.day7

import java.nio.file.Paths

fun main() {

    val inputFile = Paths.get("src/main/resources/day7/puzzle-input.txt")
    val answer = Rules(inputFile).resolveNbOfIndividualBagsRequiredIn(BagColor("shiny gold"))
    println("Answer: $answer")

}
