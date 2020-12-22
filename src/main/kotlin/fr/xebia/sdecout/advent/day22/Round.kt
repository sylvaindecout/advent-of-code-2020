package fr.xebia.sdecout.advent.day22

sealed class Round {

    data class TheEnd(private val decks: Map<Player, Deck>) : Round() {
        val winner get() = decks.filter { !it.value.isEmpty }
            .map { it.key to it.value.calculateScore() }
            .first { it.second != 0 }
            .let { Winner(it.first, it.second) }
    }

    data class Ok(val decks: Map<Player, Deck>) : Round() {

        fun next(): Round {
            val decksAndDraws: List<Pair<Player, Pair<Card, Deck>>> = decks
                .map { it.key to it.value.drawTopCard() }

            val atLeastOnePlayerIsRunningDry = decksAndDraws.any { deckAndDraw ->
                val draw = deckAndDraw.second.first
                val deck = deckAndDraw.second.second
                deck.size < draw.value
            }

            val draws = decksAndDraws.map { it.first to it.second.first }
            val decksWithoutDraws = decksAndDraws.map { it.first to it.second.second }.toMap()

            val winner = if (atLeastOnePlayerIsRunningDry) getPlayerWithHigherValueCard(draws)
            else Game(makeDeckCopies(decksAndDraws)).play().player

            val updatedDecks = addDrawsToWinnersDeck(decksWithoutDraws, draws.sortedBy { it.first != winner }, winner)

            if (onePlayerHogsAllTheCards(updatedDecks)) {
                return TheEnd(updatedDecks)
            }

            return Ok(updatedDecks)
        }

        private fun getPlayerWithHigherValueCard(draws: List<Pair<Player, Card>>) = draws
            .sortedBy { it.second }
            .reversed().first().first

        private fun makeDeckCopies(decksAndDraws: List<Pair<Player, Pair<Card, Deck>>>) =
            decksAndDraws.map { x -> x.first to x.second.second.take(x.second.first.value) }.toMap()

        private fun addDrawsToWinnersDeck(
            decksWithoutDraws: Map<Player, Deck>,
            rankedDraws: List<Pair<Player, Card>>,
            winner: Player
        ) = decksWithoutDraws
            .map { deck ->
                deck.key to if (deck.key == winner)
                    deck.value.placeAtTheBottom(rankedDraws.map { it.second })
                else deck.value
            }.toMap()

        private fun onePlayerHogsAllTheCards(updatedDecks: Map<Player, Deck>) =
            updatedDecks.count { it.value.isEmpty } == decks.size - 1

    }

}


