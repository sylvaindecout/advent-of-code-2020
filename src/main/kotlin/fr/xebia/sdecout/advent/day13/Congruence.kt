package fr.xebia.sdecout.advent.day13

data class Congruence(
    val modulus: Long,
    val remainder: Int
){
    fun appliesTo(value: Long) = (value + remainder) % modulus == 0L
}
