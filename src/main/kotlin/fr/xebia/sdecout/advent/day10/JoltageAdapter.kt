package fr.xebia.sdecout.advent.day10

data class JoltageAdapter(
    val outputJoltageRating: Int
) {
    fun accepts(inputJoltage: Int) = inputJoltage in outputJoltageRating - 3 until outputJoltageRating
}
