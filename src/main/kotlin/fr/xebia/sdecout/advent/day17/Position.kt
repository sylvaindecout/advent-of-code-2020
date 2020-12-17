package fr.xebia.sdecout.advent.day17

import fr.xebia.sdecout.advent.day17.Mode.FOUR_D
import fr.xebia.sdecout.advent.day17.Mode.THREE_D

sealed class Position {

    companion object {
        fun init(x: Int, y: Int, mode: Mode) = when (mode) {
            THREE_D -> Position3D(x, y, 0)
            FOUR_D -> Position4D(x, y, 0, 0)
        }
    }

    abstract fun getNeighbors(): List<Position>

    data class Position3D(
        val x: Int,
        val y: Int,
        val z: Int
    ): Position() {
        override fun getNeighbors() = (x - 1..x + 1).flatMap { x ->
            (y - 1..y + 1).flatMap { y ->
                (z - 1..z + 1).map { z -> Position3D(x, y, z) }
            }
        }.filter { it != this }
    }

    data class Position4D(
        val x: Int,
        val y: Int,
        val z: Int,
        val w: Int
    ): Position() {
        override fun getNeighbors() = (x - 1..x + 1).flatMap { x ->
            (y - 1..y + 1).flatMap { y ->
                (z - 1..z + 1).flatMap { z ->
                    (w - 1..w + 1).map { w -> Position4D(x, y, z, w) }
                }
            }
        }.filter { it != this }
    }

}
