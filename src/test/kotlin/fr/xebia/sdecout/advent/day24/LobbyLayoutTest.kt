package fr.xebia.sdecout.advent.day24

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class LobbyLayoutTest {

    @Test
    fun `should count tiles left with the black side up after at the end of instructions`() {
        val input = Paths.get("src/main/resources/day24/example.txt")

        val initialLayout = LobbyLayout(input).executeInstructions()
        val nbBlackTiles = initialLayout.blackTiles.count()

        assertThat(nbBlackTiles).isEqualTo(10)
    }

    @Test
    fun `should count tiles left with the black side up after 100 days`() {
        val input = Paths.get("src/main/resources/day24/example.txt")

        val initialLayout = LobbyLayout(input).executeInstructions()
        val finalLayout = initialLayout.applyDailyRules(nbDays = 100)
        val nbBlackTiles = finalLayout.blackTiles.count()

        assertThat(nbBlackTiles).isEqualTo(2_208)
    }

}
