package fr.xebia.sdecout.advent.day12.part2

import fr.xebia.sdecout.advent.day12.Orientation.*

data class Instruction(
    val action: Char,
    val value: Int
) {

    fun applyTo(ship: Ship) = when (action) {
        'N' -> ship.moveWaypoint(NORTH, value)
        'E' -> ship.moveWaypoint(EAST, value)
        'W' -> ship.moveWaypoint(WEST, value)
        'S' -> ship.moveWaypoint(SOUTH, value)
        'L' -> ship.rotateLeft(angle = value)
        'R' -> ship.rotateRight(angle = value)
        'F' -> ship.moveForward(value)
        else -> throw IllegalArgumentException("Invalid action: $action")
    }

}
