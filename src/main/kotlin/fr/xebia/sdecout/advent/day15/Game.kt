package fr.xebia.sdecout.advent.day15

class Game(private val startingNumbers: List<Int>) {

    var lastSpokenNumber = startingNumbers.last()

    private val lastTurnNumberWasSpoken = startingNumbers.indices
        .map { startingNumbers[it] to it + 1 }
        .toMap().toMutableMap()
    private val previousLastTurnNumberWasSpoken = mutableMapOf<Int, Int>()
    private var lastTurn = startingNumbers.lastIndex + 1

    fun playTurns(nbTurns: Int) {
        while (lastTurn < nbTurns) {
            playNextTurn()
        }
    }

    fun playNextTurn() {
        val nextNumber = if (previousLastTurnNumberWasSpoken.containsKey(lastSpokenNumber))
            lastTurnNumberWasSpoken[lastSpokenNumber]!! - previousLastTurnNumberWasSpoken[lastSpokenNumber]!!
        else 0
        play(lastTurn + 1, nextNumber)
    }

    private fun play(turn: Int, number: Int) {
        lastTurnNumberWasSpoken[number]?.let { previousLastTurnNumberWasSpoken[number] = it }
        lastTurnNumberWasSpoken[number] = turn
        lastSpokenNumber = number
        lastTurn = turn
    }

}
