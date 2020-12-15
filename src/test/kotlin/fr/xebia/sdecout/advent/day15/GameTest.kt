package fr.xebia.sdecout.advent.day15

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions.assertSoftly
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun `should find next number`() {
        val game = Game(listOf(0, 3, 6))

        assertSoftly {
            game.playNextTurn()
            it.assertThat(game.lastSpokenNumber).isEqualTo(0)

            game.playNextTurn()
            it.assertThat(game.lastSpokenNumber).isEqualTo(3)

            game.playNextTurn()
            it.assertThat(game.lastSpokenNumber).isEqualTo(3)

            game.playNextTurn()
            it.assertThat(game.lastSpokenNumber).isEqualTo(1)
        }
    }

    @Test
    @Tag("Integration")
    fun `should play 2020 turns with example #1`() {
        val game = Game(listOf(0, 3, 6))
        game.playTurns(2020)
        assertThat(game.lastSpokenNumber).isEqualTo(436)
    }

    @Test
    @Tag("Integration")
    fun `should play 2020 turns with example #2`() {
        val game = Game(listOf(1, 3, 2))
        game.playTurns(2020)
        assertThat(game.lastSpokenNumber).isEqualTo(1)
    }

    @Test
    @Tag("Integration")
    fun `should play 2020 turns with example #3`() {
        val game = Game(listOf(2, 1, 3))
        game.playTurns(2020)
        assertThat(game.lastSpokenNumber).isEqualTo(10)
    }

    @Test
    @Tag("Integration")
    fun `should play 2020 turns with example #4`() {
        val game = Game(listOf(1, 2, 3))
        game.playTurns(2020)
        assertThat(game.lastSpokenNumber).isEqualTo(27)
    }

    @Test
    @Tag("Integration")
    fun `should play 2020 turns with example #5`() {
        val game = Game(listOf(2, 3, 1))
        game.playTurns(2020)
        assertThat(game.lastSpokenNumber).isEqualTo(78)
    }

    @Test
    @Tag("Integration")
    fun `should play 2020 turns with example #6`() {
        val game = Game(listOf(3, 2, 1))
        game.playTurns(2020)
        assertThat(game.lastSpokenNumber).isEqualTo(438)
    }

    @Test
    @Tag("Integration")
    fun `should play 2020 turns with example #7`() {
        val game = Game(listOf(3, 1, 2))
        game.playTurns(2020)
        assertThat(game.lastSpokenNumber).isEqualTo(1836)
    }

    @Test
    @Tag("Integration")
    @Disabled
    fun `should play 30'000'000 turns with example #1`() {
        val game = Game(listOf(0, 3, 6))
        game.playTurns(30_000_000)
        assertThat(game.lastSpokenNumber).isEqualTo(175594)
    }

    @Test
    @Tag("Integration")
    @Disabled
    fun `should play 30'000'000 turns with example #2`() {
        val game = Game(listOf(1, 3, 2))
        game.playTurns(30_000_000)
        assertThat(game.lastSpokenNumber).isEqualTo(2578)
    }

    @Test
    @Tag("Integration")
    @Disabled
    fun `should play 30'000'000 turns with example #3`() {
        val game = Game(listOf(2, 1, 3))
        game.playTurns(30_000_000)
        assertThat(game.lastSpokenNumber).isEqualTo(3544142)
    }

    @Test
    @Tag("Integration")
    @Disabled
    fun `should play 30'000'000 turns with example #4`() {
        val game = Game(listOf(1, 2, 3))
        game.playTurns(30_000_000)
        assertThat(game.lastSpokenNumber).isEqualTo(261214)
    }

    @Test
    @Tag("Integration")
    @Disabled
    fun `should play 30'000'000 turns with example #5`() {
        val game = Game(listOf(2, 3, 1))
        game.playTurns(30_000_000)
        assertThat(game.lastSpokenNumber).isEqualTo(6895259)
    }

    @Test
    @Tag("Integration")
    @Disabled
    fun `should play 30'000'000 turns with example #6`() {
        val game = Game(listOf(3, 2, 1))
        game.playTurns(30_000_000)
        assertThat(game.lastSpokenNumber).isEqualTo(18)
    }

    @Test
    @Tag("Integration")
    @Disabled
    fun `should play 30'000'000 turns with example #7`() {
        val game = Game(listOf(3, 1, 2))
        game.playTurns(30_000_000)
        assertThat(game.lastSpokenNumber).isEqualTo(362)
    }

}
