package fr.xebia.sdecout.advent.day20

data class Image(val data: Bitmap) {

    fun countHashesExcluding(pattern: Pattern) = data.nbHashes - pattern.nbHashes * countOccurrences(pattern)

    private fun countOccurrences(pattern: Pattern) = data.possibleVariants
        .map { it.countOccurrences(pattern) }
        .first { it > 0 }

    override fun toString() = data.toString()

}
