package fr.xebia.sdecout.advent.day13

import java.nio.file.Files.lines
import java.nio.file.Path

data class NextBusFinder(
    val earliestDepartureTime: Long,
    val buses: List<Bus>
) {

    constructor(inputFile: Path) : this(
        earliestDepartureTime = lines(inputFile).findFirst().get()
            .toLong(),
        buses = lines(inputFile).skip(1).findFirst().get()
            .split(",")
            .map { Bus.parse(it) }
            .filterIsInstance<Bus.Active>()
    )

    fun findNextBus() = buses
        .filterIsInstance<Bus.Active>()
        .minByOrNull { it.nextDepartureTime(earliestDepartureTime) }!!
        .let { NextBus(
                id = it.id,
                waitingTime = it.nextDepartureTime(earliestDepartureTime) - earliestDepartureTime
        ) }

}
