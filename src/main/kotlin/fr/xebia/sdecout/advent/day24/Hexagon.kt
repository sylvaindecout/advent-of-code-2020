package fr.xebia.sdecout.advent.day24

data class Hexagon(
    val x: Int,
    val y: Int
) {
    val adjacentHexagons by lazy { Direction.values().map { direction -> direction.from(this) } }
}
