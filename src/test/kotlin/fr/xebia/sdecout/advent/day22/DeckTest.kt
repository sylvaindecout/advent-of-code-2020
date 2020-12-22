package fr.xebia.sdecout.advent.day22

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DeckTest {

    @Test
    fun `should calculate score`() {
        val deck = Deck(listOf(3, 2, 10, 6, 8, 5, 9, 4, 7, 1)
            .map { Card(it) })
        assertThat(deck.calculateScore()).isEqualTo(306)
    }

}
