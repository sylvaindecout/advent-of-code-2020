package fr.xebia.sdecout.advent.day17

import fr.xebia.sdecout.advent.day17.Mode.FOUR_D
import fr.xebia.sdecout.advent.day17.Mode.THREE_D
import fr.xebia.sdecout.advent.day17.Position.Position3D
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class PocketDimensionTest {

    @Test
    @Tag("Integration")
    fun `should initialize pocket dimension`() {
        val input = Paths.get("src/main/resources/day17/example.txt")

        val dimension = PocketDimension.init(input, mode = THREE_D)

        assertThat(dimension.activeCubes).containsExactlyInAnyOrder(
            Position3D(1, 0, 0),
            Position3D(2, 1, 0),
            Position3D(0, 2, 0),
            Position3D(1, 2, 0),
            Position3D(2, 2, 0)
        )
    }

    @Test
    fun `should simulate 1 cycle`() {
        val initialDimension = PocketDimension(listOf(
            Position3D(1, 0, 0),
            Position3D(2, 1, 0),
            Position3D(0, 2, 0),
            Position3D(1, 2, 0),
            Position3D(2, 2, 0)
        ))

        val updatedDimension = initialDimension.simulateOneCycle()

        assertThat(updatedDimension.activeCubes).containsExactlyInAnyOrder(
            Position3D(0, 1, -1),
            Position3D(0, 1, 0),
            Position3D(0, 1, 1),
            Position3D(2, 1, 0),
            Position3D(1, 2, 0),
            Position3D(2, 2, -1),
            Position3D(2, 2, 0),
            Position3D(2, 2, 1),
            Position3D(1, 3, -1),
            Position3D(1, 3, 0),
            Position3D(1, 3, 1)
        )
    }

    @Test
    @Tag("Integration")
    fun `should get number of active cubes after 6 cycles in 3D mode`() {
        val input = Paths.get("src/main/resources/day17/example.txt")

        val dimension = (0 until 6)
            .fold(PocketDimension.init(input, THREE_D)) { dimension, _ -> dimension.simulateOneCycle() }

        assertThat(dimension.activeCubes).hasSize(112)
    }

    @Test
    @Tag("Integration")
    fun `should get number of active cubes after 6 cycles in 4D mode`() {
        val input = Paths.get("src/main/resources/day17/example.txt")

        val dimension = (0 until 6)
            .fold(PocketDimension.init(input, FOUR_D)) { dimension, _ -> dimension.simulateOneCycle() }

        assertThat(dimension.activeCubes).hasSize(848)
    }

}
