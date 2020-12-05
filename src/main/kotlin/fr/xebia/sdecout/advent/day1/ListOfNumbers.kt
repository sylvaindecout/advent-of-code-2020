package fr.xebia.sdecout.advent.day1

import java.nio.file.Files
import java.nio.file.Path

class ListOfNumbers(file: Path) {

    private val input = Files.readAllLines(file).map { it.toInt() }

    fun findCombinationSummingTo(sum: Int) = input
        .flatMap { item1 -> input.flatMap { item2 -> input.map { item3 -> Triple(item1, item2, item3) } } }
        .filter { it.first != it.second && it.second != it.third && it.first != it.third }
        .first { it.first + it.second + it.third == sum }

}
