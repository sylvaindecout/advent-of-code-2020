package fr.xebia.sdecout.advent.day20

import java.nio.file.Files.readString
import java.nio.file.Path
import kotlin.math.sqrt

class Tiles(inputFile: Path) {

    private val tiles = readString(inputFile).toTiles()

    private val nbTilesPerImageSide by lazy { sqrt(tiles.size.toFloat() / 8).toInt() }

    fun getCornerTileIds() = tiles.filter { it.adjacentTiles.count() == 2 }.map { it.id }.distinct()

    fun reassemble() = Assembly(nbTilesPerImageSide)
        .selectTopLeftCornerTile(tiles)
        .fillFirstRow(tiles)
        .fillAllOtherRows(tiles)
        .toImage(tiles)

    private fun String.toTiles() = this.split("\n\n")
        .map { it.toTile().possibleVariants }
        .flatten()
        .also { tiles -> tiles.forEach { it.assembleAdjacentTiles(tiles) } }

    private fun String.toTile() = this.split("\n")
        .filter { it.isNotBlank() }
        .let { lines ->
            Tile(
                id = lines.first().filter { it.isDigit() }.toInt(),
                data = Array(lines.size - 1) { y ->
                    BooleanArray(lines[1].length) { x -> lines[y + 1][x] == '#' }
                }.let { Bitmap(it) }
            )
        }

}
