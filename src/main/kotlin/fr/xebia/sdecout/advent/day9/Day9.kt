package fr.xebia.sdecout.advent.day9

import java.nio.file.Paths

fun main() {

    val analyzer = DataEncryptionAnalyzer(
        inputFile = Paths.get("src/main/resources/day9/puzzle-input.txt"),
        preambleSize = 25
    )
    val answer = analyzer.findEncryptionWeakness()

    println("Answer: $answer")

}

