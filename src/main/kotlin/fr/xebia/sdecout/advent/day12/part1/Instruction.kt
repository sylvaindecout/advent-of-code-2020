package fr.xebia.sdecout.advent.day12.part1

import fr.xebia.sdecout.advent.day12.Orientation.*

data class Instruction(
    val action: Char,
    val value: Int
) {

    fun applyTo(ship: Ship) = when (action) {
        'N' -> ship.move(NORTH, value)
        'E' -> ship.move(EAST, value)
        'W' -> ship.move(WEST, value)
        'S' -> ship.move(SOUTH, value)
        'L' -> ship.rotateLeft(angle = value)
        'R' -> ship.rotateRight(angle = value)
        'F' -> ship.moveForward(value)
        else -> throw IllegalArgumentException("Invalid action: $action")
    }

}
