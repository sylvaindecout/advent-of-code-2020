package fr.xebia.sdecout.advent.day17

import fr.xebia.sdecout.advent.day17.Position.Position3D
import fr.xebia.sdecout.advent.day17.Position.Position4D
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PositionTest {

    @Test
    fun `should resolve neighbors for 3D position`() {
        val position = Position3D(1, 2, 3)

        val neighbors = position.getNeighbors()

        assertThat(neighbors)
            .hasSize(26)
            .doesNotContain(position)
    }

    @Test
    fun `should resolve neighbors for 4D position`() {
        val position = Position4D(1, 2, 3, 4)

        val neighbors = position.getNeighbors()

        assertThat(neighbors)
            .hasSize(80)
            .doesNotContain(position)
    }

}
