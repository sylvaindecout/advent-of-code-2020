package fr.xebia.sdecout.advent.day20

data class Edge(val content: BooleanArray) {

    val size get() = content.size

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!content.contentEquals((other as Edge).content)) return false
        return true
    }

    override fun hashCode() = content.contentHashCode()

}
