package fr.xebia.sdecout.advent.day24

import fr.xebia.sdecout.advent.day24.Direction.*
import java.nio.file.Files.newBufferedReader
import java.nio.file.Path

class LobbyLayout(private val inputFile: Path) {

    fun executeInstructions() = newBufferedReader(inputFile).useLines { lines ->
        lines.map { line -> line.toInstruction() }
            .map { instruction -> instruction.resolveTargetTile() }
            .fold(HexagonalTiling()) { tiling, tile -> tiling.flip(tile) }
    }

    private fun String.toInstruction(): List<Direction> {
        val instruction = mutableListOf<Direction>()
        var index = 0
        while (index < this.length) {
            val direction =
                if (this[index] in setOf('n', 's')) "${this[index]}${this[index + 1]}"
                else "${this[index]}"
            instruction.add(direction.toDirection())
            index += direction.length
        }
        return instruction
    }

    private fun List<Direction>.resolveTargetTile() = fold(Hexagon(0, 0)) { tile, direction -> direction.from(tile) }

    private fun String.toDirection() = when (this) {
        "e" -> EAST
        "se" -> SOUTHEAST
        "sw" -> SOUTHWEST
        "w" -> WEST
        "nw" -> NORTHWEST
        "ne" -> NORTHEAST
        else -> throw IllegalArgumentException("Unexpected instruction: $this")
    }

}
