package fr.xebia.sdecout.advent.day22

data class Game(private val decks: Map<Player, Deck>) {

    private val history = decks.map { it.key to mutableSetOf<Deck>() }.toMap()

    fun play() = keepPlayingUntilTheEnd(Round.Ok(decks))

    private fun keepPlayingUntilTheEnd(round: Round): Winner = when (round) {
        is Round.Ok -> settleForDefaultWinnerIfThereIsAnInfiniteLoop(round.decks, defaultWinner = Player(1))
            ?: keepPlayingUntilTheEnd(round.next())
        is Round.TheEnd -> round.winner
    }

    private fun settleForDefaultWinnerIfThereIsAnInfiniteLoop(
        decks: Map<Player, Deck>,
        defaultWinner: Player
    ) = if (!addToHistory(decks)) Winner(defaultWinner, decks[defaultWinner]!!.calculateScore())
    else null

    private fun addToHistory(decks: Map<Player, Deck>) = decks.any { history[it.key]!!.add(it.value) }

}
