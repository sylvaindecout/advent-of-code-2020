package fr.xebia.sdecout.advent.day23

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun `should find labels after 10 moves`() {
        val game = Game(
            input = "389125467",
            nbCups = 9,
            nbMoves = 10
        )

        val orderStartingFromCup1 = game.play()

        assertThat(orderStartingFromCup1.drop(1).joinToString("")).isEqualTo("92658374")
    }

    @Test
    fun `should find labels after 100 moves`() {
        val game = Game(
            input = "389125467",
            nbCups = 9,
            nbMoves = 100
        )

        val orderStartingFromCup1 = game.play()

        assertThat(orderStartingFromCup1.drop(1).joinToString("")).isEqualTo("67384529")
    }

    @Test
    fun `should find labels for example in crab mode`() {
        val game = Game(
            input = "389125467",
            nbCups = 1_000_000,
            nbMoves = 10_000_000
        )

        val orderStartingFromCup1 = game.play()

        assertThat(orderStartingFromCup1.take(3).toList()).containsExactly(
            Cup(1), Cup(934_001), Cup(159_792)
        )
    }

}
