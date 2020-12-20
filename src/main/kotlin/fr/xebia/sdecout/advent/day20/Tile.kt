package fr.xebia.sdecout.advent.day20

data class Tile(
    val id: Int,
    val data: Bitmap
) {

    var left: Tile? = null
    var top: Tile? = null
    var right: Tile? = null
    var bottom: Tile? = null

    val adjacentTiles get() = listOfNotNull(left, top, right, bottom)

    val possibleVariants by lazy { this.data.possibleVariants.map { Tile(this.id, it) } }

    fun assembleAdjacentTiles(tiles: List<Tile>) {
        val candidates = tiles.filter { id != it.id }
        candidates.find { data.leftEdge == it.data.rightEdge }?.let { left = it }
        candidates.find { data.topEdge == it.data.bottomEdge }?.let { top = it }
        candidates.find { data.rightEdge == it.data.leftEdge }?.let { right = it }
        candidates.find { data.bottomEdge == it.data.topEdge }?.let { bottom = it }
    }

}
