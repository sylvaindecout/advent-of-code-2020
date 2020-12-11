package fr.xebia.sdecout.advent.day11

import fr.xebia.sdecout.advent.day11.Seat.*

data class SeatingState(val seats: List<List<Seat>>) {

    fun countOccupiedSeats() = seats
        .flatMap { row -> row.map { it } }
        .count { it == OCCUPIED }

    fun update(mode: Mode, tolerance: Int): SeatingState = SeatingState(seats.indices.map { i ->
        seats[i].indices.map { j ->
            updateSeatAt(Position(i, j), mode, tolerance)
        }
    })

    private fun updateSeatAt(position: Position, mode: Mode, tolerance: Int) = when (seatAt(position)) {
        EMPTY -> if (getNextSeatsInAllDirections(position, mode).none { it == OCCUPIED }) OCCUPIED else EMPTY
        OCCUPIED -> if (getNextSeatsInAllDirections(position, mode).count { it == OCCUPIED } >= tolerance) EMPTY else OCCUPIED
        FLOOR -> FLOOR
    }

    private fun getNextSeatsInAllDirections(position: Position, mode: Mode): List<Seat> {
        return ALL_DIRECTIONS.mapNotNull { getNextSeatInDirection(position, it, mode) }
    }

    private fun getNextSeatInDirection(position: Position, direction: Direction, mode: Mode) = when (mode) {
        Mode.ADJACENT_SEATS -> getAdjacentSeatInDirection(position, direction)
        Mode.NEXT_VISIBLE_SEATS -> getNextVisibleSeatInDirection(position, direction)
    }

    private fun getAdjacentSeatInDirection(position: Position, direction: Direction) = direction.next(position)
        .let { nextPosition -> if (exists(nextPosition)) seatAt(nextPosition) else null }

    private fun getNextVisibleSeatInDirection(position: Position, direction: Direction): Seat? {
        val nextPosition = direction.next(position)
        return if (exists(nextPosition))
            if (seatAt(nextPosition) == FLOOR) getNextVisibleSeatInDirection(nextPosition, direction)
            else seatAt(nextPosition)
        else null
    }

    private fun exists(nextPosition: Position) =
        nextPosition.i in seats.indices && nextPosition.j in seats[nextPosition.i].indices

    private fun seatAt(position: Position) = seats[position.i][position.j]

    companion object {
        val ALL_DIRECTIONS = listOf(
            Direction { Position(it.i - 1, it.j - 1) },
            Direction { Position(it.i - 1, it.j) },
            Direction { Position(it.i - 1, it.j + 1) },
            Direction { Position(it.i, it.j - 1) },
            Direction { Position(it.i, it.j + 1) },
            Direction { Position(it.i + 1, it.j - 1) },
            Direction { Position(it.i + 1, it.j) },
            Direction { Position(it.i + 1, it.j + 1) }
        )
    }

}
