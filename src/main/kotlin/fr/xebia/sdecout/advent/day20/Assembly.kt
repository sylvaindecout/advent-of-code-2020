package fr.xebia.sdecout.advent.day20

data class Assembly(private val nbTilesPerImageSide: Int) {

    private val content = Array(nbTilesPerImageSide) { Array<Tile?>(nbTilesPerImageSide) { null } }

    private fun set(x: Int, y: Int, value: Tile): Assembly {
        this.content[x][y] = value
        return this
    }

    fun selectTopLeftCornerTile(tiles: List<Tile>): Assembly {
        return set(0, 0, tiles.first { it.isTopLeftCornerTile() })
    }

    fun fillFirstRow(tiles: List<Tile>) = (1 until nbTilesPerImageSide)
        .fold(this) { assembly, y ->
            assembly.set(0, y, tiles.first { it.matchesRightEdgeOfThePreviousTile(assembly.content[0][y - 1]!!) })
        }

    fun fillAllOtherRows(tiles: List<Tile>) = (1 until nbTilesPerImageSide)
        .fold(this) { assembly, x ->
            assembly.fillNextRow(x, tiles)
        }

    private fun fillNextRow(x: Int, tiles: List<Tile>) = (0 until nbTilesPerImageSide)
        .fold(this) { assembly, y ->
            assembly.set(x, y, tiles.first { it.matchesBottomEdgeOfTileOfThePreviousRow(assembly.content[x - 1][y]!!) })
        }

    private fun Tile.isTopLeftCornerTile() =
        this.adjacentTiles.count() == 2 && this.right != null && this.bottom != null

    private fun Tile.matchesRightEdgeOfThePreviousTile(previousTile: Tile) =
        this.id == previousTile.right!!.id && this.data.leftEdge == previousTile.data.rightEdge

    private fun Tile.matchesBottomEdgeOfTileOfThePreviousRow(previousTile: Tile) =
        this.id == previousTile.bottom!!.id && this.data.topEdge == previousTile.data.bottomEdge

    fun toImage(tiles: List<Tile>): Image {
        val borderlessTileWidth = tiles.first().data.withoutEdges.topEdge.size
        val actualImageWidth = nbTilesPerImageSide * borderlessTileWidth
        val actualImage = MutableBitmap(actualImageWidth)
        (0 until nbTilesPerImageSide).forEach { x ->
            (0 until nbTilesPerImageSide).forEach { y ->
                this.content[x][y]!!.data.withoutEdges.content.indices.forEach { x2 ->
                    this.content[x][y]!!.data.withoutEdges.content[x2].indices.forEach { y2 ->
                        actualImage.set(
                            x * borderlessTileWidth + x2,
                            y * borderlessTileWidth + y2,
                            this.content[x][y]!!.data.withoutEdges.content[x2][y2]
                        )
                    }
                }
            }
        }
        return Image(actualImage.toBitmap())
    }

}
