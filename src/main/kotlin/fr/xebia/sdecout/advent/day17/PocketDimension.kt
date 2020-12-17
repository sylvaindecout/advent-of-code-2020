package fr.xebia.sdecout.advent.day17

import java.nio.file.Files.readAllLines
import java.nio.file.Path

data class PocketDimension(val activeCubes: List<Position>) {

    fun simulateOneCycle() = PocketDimension(activeCubes
        .flatMap { it.getNeighbors() }
        .distinct()
        .mapNotNull { candidateCube ->
            candidateCube.getNeighbors().count { it in activeCubes }.let { nbActiveNeighbors ->
                if (candidateCube in activeCubes && nbActiveNeighbors in 2..3) candidateCube
                else if (candidateCube !in activeCubes && nbActiveNeighbors == 3) candidateCube
                else null
            }
        })

    companion object {
        fun init(inputFile: Path, mode: Mode) = readAllLines(inputFile).let { lines ->
            PocketDimension(lines.indices.flatMap { y ->
                lines.indices.mapNotNull { x ->
                    if (lines[y][x] == '#') Position.init(x, y, mode) else null
                }
            })
        }
    }
}
