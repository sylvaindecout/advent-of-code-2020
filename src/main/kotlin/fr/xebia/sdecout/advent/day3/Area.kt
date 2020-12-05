package fr.xebia.sdecout.advent.day3

import java.nio.file.Files
import java.nio.file.Path

class Area(file: Path) {

    private val lines = Files.readAllLines(file)
    private val width = lines[0].length

    fun getNbOfTreesEncountered(
        slope: Slope,
        position: Position = Position(0, 0),
        count: Int = 0
    ): Int = if (position.y < lines.size) getNbOfTreesEncountered(
        slope = slope,
        position = Position(
            slope.x.invoke(position.x) % width, slope.y.invoke(position.y)
        ),
        count = if (lines[position.y][position.x] == '#') count + 1 else count
    ) else count

}
