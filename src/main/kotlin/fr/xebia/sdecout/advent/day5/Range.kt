package fr.xebia.sdecout.advent.day5

data class Range(val min: Int, val max: Int) {

    fun getUpperHalf() = Range(min + size() / 2, max)

    fun getLowerHalf() = Range(min, max - size() / 2)

    fun getValue() = if (max == min) max else throw IllegalStateException("Range consists in several values ($this)")

    private fun size() = max - min + 1

}
