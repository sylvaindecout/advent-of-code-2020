package fr.xebia.sdecout.advent.day13

data class Constraint(
    val busId: Long,
    val offset: Int
) {
    fun asCongruence() = Congruence(busId, -offset)
}
