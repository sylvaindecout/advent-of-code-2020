package fr.xebia.sdecout.advent.day12.part1

import fr.xebia.sdecout.advent.day12.Orientation
import fr.xebia.sdecout.advent.day12.Position

data class Ship(
    val position: Position,
    val heading: Orientation
) {

    fun move(direction: Orientation, units: Int) = Ship(
        position = direction.moveForward(position, units),
        heading = heading
    )

    fun moveForward(units: Int) = move(heading, units)

    fun rotateLeft(angle: Int) = Ship(
        position = position,
        heading = heading.rotateLeft(angle)
    )

    fun rotateRight(angle: Int) = Ship(
        position = position,
        heading = heading.rotateRight(angle)
    )

}
