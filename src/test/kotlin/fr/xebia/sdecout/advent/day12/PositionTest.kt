package fr.xebia.sdecout.advent.day12

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PositionTest {

    @Test
    fun `should compute manhattan distance`() {
        val position = Position(17, -8)

        val manhattanDistance = position.manhattanDistance

        assertThat(manhattanDistance).isEqualTo(25)
    }

    @Test
    fun `should rotate clockwise with origin reference`() {
        val position = Position(2, 5)

        val rotatedPosition = position.rotateRight()

        assertThat(rotatedPosition).isEqualTo(Position(5, -2))
    }

    @Test
    fun `should rotate counter-clockwise with origin reference`() {
        val position = Position(2, 5)

        val rotatedPosition = position.rotateLeft()

        assertThat(rotatedPosition).isEqualTo(Position(-5, 2))
    }

}
