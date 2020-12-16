package fr.xebia.sdecout.advent.day16

data class Rule(
    val field: String,
    private val validRanges: List<IntRange>
) {

    fun validate(value: Int) = validRanges.any { value in it }

    companion object {
        fun parse(line: String) = line.split(": ").let { splitLine ->
            Rule(
                splitLine[0],
                splitLine[1].split(" or ").map { range ->
                    range.split("-").let { it[0].toInt()..it[1].toInt() }
                }
            )
        }
    }

}
