package fr.xebia.sdecout.advent.day24

data class HexagonalTiling(
    val blackTiles: Set<Hexagon> = emptySet()
) {

    private val whiteTiles get() = blackTiles.flatMap { it.adjacentHexagons }.distinct()

    fun flip(tile: Hexagon) = HexagonalTiling(
        if (tile in blackTiles) blackTiles - tile
        else blackTiles + tile
    )

    fun applyDailyRules(nbDays: Int) = (1..nbDays)
        .fold(this) { layout, _ -> layout.applyDailyRules() }

    private fun applyDailyRules(): HexagonalTiling {
        val updatedBlackTiles = blackTiles.toMutableSet()
        blackTiles.forEach { blackTile ->
            if (blackTile.adjacentHexagons.count { it in blackTiles } !in 1..2) updatedBlackTiles -= blackTile
        }
        whiteTiles.forEach { whiteTile ->
            if (whiteTile.adjacentHexagons.count { it in blackTiles } == 2) updatedBlackTiles += whiteTile
        }
        return HexagonalTiling(updatedBlackTiles)
    }

}
