package fr.xebia.sdecout.advent.day20

data class Bitmap(val content: Array<BooleanArray>) { //FIXME: make it private

    val nbHashes by lazy { content.sumBy { line -> line.count { it } } }

    val topEdge by lazy { Edge(content[0]) }
    val bottomEdge by lazy { Edge(content[content.size - 1]) }
    val leftEdge by lazy { Edge(content.map { it[0] }.toBooleanArray()) }
    val rightEdge by lazy { Edge(content.map { it[it.size - 1] }.toBooleanArray()) }

    val withoutEdges by lazy {
        Bitmap(content.sliceArray(1 until content.lastIndex)
            .map { it.sliceArray(1 until it.lastIndex) }
            .toTypedArray())
    }

    val possibleVariants by lazy {
        listOf(
            this,
            this.rotateClockwise(times = 1),
            this.rotateClockwise(times = 2),
            this.rotateClockwise(times = 3),
            this.flip(),
            this.flip().rotateClockwise(times = 1),
            this.flip().rotateClockwise(times = 2),
            this.flip().rotateClockwise(times = 3),
        )
    }

    private fun flip() = Bitmap(this.content.reversedArray())

    private fun rotateClockwise() = Bitmap(Array(this.content.first().size) { x: Int ->
        BooleanArray(this.content.size) { y: Int ->
            this.content[this.content.lastIndex - y][x]
        }
    })

    fun rotateClockwise(times: Int = 1) = (0 until times).fold(this) { bitmap, _ -> bitmap.rotateClockwise() }

    fun countOccurrences(pattern: Pattern) = content.indices.sumBy { x ->
        content[x].indices.count { y -> hasPatternOnIndex(x, y, pattern) }
    }

    private fun hasPatternOnIndex(x: Int, y: Int, pattern: Pattern): Boolean {
        if (isOutOfBounds(x, y, pattern)) return false
        for (x2 in pattern.content.indices) {
            for (y2 in pattern.content[x2].indices) {
                if (pattern.content[x2][y2] && !this.content[x + x2][y + y2]) {
                    return false
                }
            }
        }
        return true
    }

    private fun isOutOfBounds(x: Int, y: Int, pattern: Pattern) = x + pattern.content.lastIndex > this.content.lastIndex
            || y + pattern.content.first().size - 1 > this.content.first().lastIndex

    override fun toString() = content.joinToString(separator = "\n", postfix = "\n") { line ->
        line.map { if (it) '#' else '.' }.joinToString(separator = "")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!content.contentDeepEquals((other as Bitmap).content)) return false
        return true
    }

    override fun hashCode() = content.contentDeepHashCode()

}
