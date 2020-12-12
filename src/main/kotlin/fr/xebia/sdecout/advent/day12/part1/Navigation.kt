package fr.xebia.sdecout.advent.day12.part1

import fr.xebia.sdecout.advent.day12.Orientation.EAST
import fr.xebia.sdecout.advent.day12.Position
import java.nio.file.Files.newBufferedReader
import java.nio.file.Path

data class Navigation(private val inputFile: Path) {

    fun applyAllInstructions() = newBufferedReader(inputFile).useLines {
        it.fold(Ship(
                position = Position(0, 0),
                heading = EAST
        )) { ship, line ->
            Instruction(
                action = line[0],
                value = line.substring(1).toInt()
            ).applyTo(ship)
        }.position
    }

}
