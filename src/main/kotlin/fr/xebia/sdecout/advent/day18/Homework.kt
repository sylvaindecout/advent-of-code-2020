package fr.xebia.sdecout.advent.day18

import java.nio.file.Files.readAllLines
import java.nio.file.Path

class Homework(inputFile: Path, precedence: Precedence) {

    private val expressions: List<Expression> = readAllLines(inputFile).map { Expression(it, precedence) }

    fun resolve() = expressions.map { it.resolve() }

}
