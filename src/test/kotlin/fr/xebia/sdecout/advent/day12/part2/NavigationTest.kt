package fr.xebia.sdecout.advent.day12.part2

import fr.xebia.sdecout.advent.day12.Position
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class NavigationTest {

    @Test
    fun `should figure out where the navigation instructions lead`() {
        val inputFile = Paths.get("src/main/resources/day12/example.txt")

        val finalPosition = Navigation(inputFile).applyAllInstructions()

        assertThat(finalPosition).isEqualTo(Position(214, -72))
    }

}
