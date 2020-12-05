package fr.xebia.sdecout.advent.day2

import java.nio.file.Paths

fun main() {

    val inputFile = Paths.get("src/main/resources/day2/puzzle-input.txt")
    val nbValidPasswords = PasswordFile(inputFile).getNbValidPassword()
    println("Answer: $nbValidPasswords")

}
