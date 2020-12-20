package fr.xebia.sdecout.advent.day20

data class Pattern(val content: Array<BooleanArray>) {

    val nbHashes by lazy { content.sumBy { line -> line.count { it } } }

    override fun toString() = content.joinToString(separator = "\n", postfix = "\n") { line ->
        line.map { if (it) '#' else '.' }.joinToString(separator = "")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!content.contentDeepEquals((other as Pattern).content)) return false
        return true
    }

    override fun hashCode() = content.contentDeepHashCode()

}
