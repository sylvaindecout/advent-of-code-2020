package fr.xebia.sdecout.advent.day18

import fr.xebia.sdecout.advent.day18.Precedence.ADDITION_OVER_PRODUCT
import java.nio.file.Paths

fun main() {

    val input = Paths.get("src/main/resources/day18/puzzle-input.txt")

    val answer = Homework(input, precedence = ADDITION_OVER_PRODUCT).resolve().sum()

    println("Answer: $answer")

}
