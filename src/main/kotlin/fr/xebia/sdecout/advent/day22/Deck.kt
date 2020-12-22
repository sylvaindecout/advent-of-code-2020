package fr.xebia.sdecout.advent.day22

data class Deck(val cards: List<Card>) {

    val size get() = cards.size
    val isEmpty get() = cards.isEmpty()

    fun drawTopCard() = Pair(
        cards.first(),
        Deck(cards.takeLast(size - 1))
    )

    fun placeAtTheBottom(cards: List<Card>) = Deck(this.cards + cards)

    fun calculateScore() = cards.indices
        .fold(0) { score, index ->
            score + cards[index].value * (cards.size - index)
        }

    fun take(n: Int) = Deck(cards.take(n))

}
