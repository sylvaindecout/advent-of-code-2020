package fr.xebia.sdecout.advent.day11

import java.nio.file.Files
import java.nio.file.Path

class Seating(inputFile: Path) {

    private val initialState: SeatingState = parse(inputFile)

    fun updateUntilStabilized(formerState: SeatingState = initialState, mode: Mode, tolerance: Int): SeatingState =
        formerState.update(mode, tolerance).let {
            if (it == formerState) it else updateUntilStabilized(it, mode, tolerance)
        }

    companion object {
        fun parse(inputFile: Path): SeatingState {
            val lines = Files.readAllLines(inputFile)
            val seats = lines.indices.map { i ->
                val line = lines[i].toCharArray()
                line.indices.map { j ->
                    Seat.parse(line[j])
                }
            }
            return SeatingState(seats)
        }
    }

}
