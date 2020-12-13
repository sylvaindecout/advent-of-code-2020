package fr.xebia.sdecout.advent.day13

import java.nio.file.Files.lines
import java.nio.file.Path

data class BusDepartureSequences(private val constraints: List<Constraint>) {

    constructor(inputFile: Path) : this(parse(inputFile))

    fun findEarliestTimestampWithOffsetsMatchingPositionsInTheList() = constraints
        .map { it.asCongruence() }
        .let { ChineseRemainderTheorem(it).computeRemainder() }

    companion object {
        private fun parse(inputFile: Path) = lines(inputFile).skip(1).findFirst().get()
            .split(",")
            .let { splitLine ->
                splitLine.indices
                    .filter { splitLine[it] != "x" }
                    .map { Constraint(busId = splitLine[it].toLong(), offset = -it) }
                    .sortedBy { it.offset }.reversed()
            }
    }

}
