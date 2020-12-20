package fr.xebia.sdecout.advent.day20

data class MutableBitmap(private val width: Int) {

    private val content: Array<BooleanArray> = Array(width) { BooleanArray(width) }

    fun set(x: Int, y: Int, value: Boolean) {
        content[x][y] = value
    }

    fun toBitmap() = Bitmap(content)

}
