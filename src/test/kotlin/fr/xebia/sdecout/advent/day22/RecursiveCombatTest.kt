package fr.xebia.sdecout.advent.day22

import fr.xebia.sdecout.advent.day22.Player
import fr.xebia.sdecout.advent.day22.RecursiveCombat
import fr.xebia.sdecout.advent.day22.Winner
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class RecursiveCombatTest {

    @Test
    @Tag("Integration")
    fun `should calculate score of the winning player`() {
        val input = Paths.get("src/main/resources/day22/example.txt")
        val crabCombat = RecursiveCombat(input)

        val scoreOfTheWinningPlayer = crabCombat.play()

        assertThat(scoreOfTheWinningPlayer).isEqualTo(Winner(player = Player(2), score = 291))
    }

    @Test
    @Tag("Integration")
    fun `should calculate score of the winning player for an infinite game`() {
        val input = Paths.get("src/main/resources/day22/example-infinite.txt")
        val crabCombat = RecursiveCombat(input)

        val scoreOfTheWinningPlayer = crabCombat.play()

        assertThat(scoreOfTheWinningPlayer).isEqualTo(Winner(player = Player(1), score = 105))
    }

}
