package fr.xebia.sdecout.advent.day22

data class Card(val value: Int) : Comparable<Card> {
    override fun compareTo(other: Card) = value.compareTo(other.value)
}
