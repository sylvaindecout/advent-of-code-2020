package fr.xebia.sdecout.advent.day12

import kotlin.math.absoluteValue

data class Position(
    val x: Int,
    val y: Int
) {

    val manhattanDistance: Int by lazy { x.absoluteValue + y.absoluteValue }

    fun rotateRight() = Position(y, -x)

    fun rotateLeft() = Position(-y, x)

}
