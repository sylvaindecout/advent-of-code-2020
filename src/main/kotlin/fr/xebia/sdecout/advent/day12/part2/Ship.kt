package fr.xebia.sdecout.advent.day12.part2

import fr.xebia.sdecout.advent.day12.Orientation
import fr.xebia.sdecout.advent.day12.Position

data class Ship(
    val position: Position,
    val relativeWaypointPosition: Position
) {

    fun moveWaypoint(moveOrientation: Orientation, units: Int) = Ship(
        position = position,
        relativeWaypointPosition = moveOrientation.moveForward(relativeWaypointPosition, units)
    )

    fun moveForward(units: Int) = Ship(
        position = Position(
            x = position.x + relativeWaypointPosition.x * units,
            y = position.y + relativeWaypointPosition.y * units
        ),
        relativeWaypointPosition = relativeWaypointPosition
    )

    fun rotateLeft(angle: Int) = Ship(
        position = position,
        relativeWaypointPosition = (0 until angle / 90).fold(relativeWaypointPosition) { waypoint, _ -> waypoint.rotateLeft() }
    )

    fun rotateRight(angle: Int) = Ship(
        position = position,
        relativeWaypointPosition = (0 until angle / 90).fold(relativeWaypointPosition) { waypoint, _ -> waypoint.rotateRight() }
    )

}
