package fr.xebia.sdecout.advent.day5

import java.nio.file.Files.newBufferedReader
import java.nio.file.Path

class SeatFinder(file: Path) {

    private val occupiedSeats = newBufferedReader(file).useLines { it.map { line -> SeatPosition.fromCode(line) } }

    fun findUnoccupiedSeat(): SeatPosition {
        val possibleRows = occupiedSeats.minOf { it.row } + 1 until occupiedSeats.maxOf { it.row }
        val possibleSeats = (0..7).flatMap { column ->
            possibleRows.map { row -> SeatPosition(row, column) }
        }
        return possibleSeats.find { it !in occupiedSeats }
            ?: throw IllegalStateException("No available seat was found")
    }

}
