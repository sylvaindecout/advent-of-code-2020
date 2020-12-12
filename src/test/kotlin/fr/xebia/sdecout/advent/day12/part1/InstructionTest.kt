package fr.xebia.sdecout.advent.day12.part1

import fr.xebia.sdecout.advent.day12.Position
import fr.xebia.sdecout.advent.day12.Orientation.EAST
import fr.xebia.sdecout.advent.day12.Orientation.SOUTH
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InstructionTest {

    @Test
    fun `should apply F10`() {
        val ship = Ship(Position(0, 0), EAST)
        val instruction = Instruction('F', 10)

        val actual = instruction.applyTo(ship)

        assertThat(actual).isEqualTo(Ship(Position(10, 0), EAST))
    }

    @Test
    fun `should apply N3`() {
        val ship = Ship(Position(10, 0), EAST)
        val instruction = Instruction('N', 3)

        val actual = instruction.applyTo(ship)

        assertThat(actual).isEqualTo(Ship(Position(10, 3), EAST))
    }

    @Test
    fun `should apply F7`() {
        val ship = Ship(Position(10, 3), EAST)
        val instruction = Instruction('F', 7)

        val actual = instruction.applyTo(ship)

        assertThat(actual).isEqualTo(Ship(Position(17, 3), EAST))
    }

    @Test
    fun `should apply R90`() {
        val ship = Ship(Position(17, 3), EAST)
        val instruction = Instruction('R', 90)

        val actual = instruction.applyTo(ship)

        assertThat(actual).isEqualTo(Ship(Position(17, 3), SOUTH))
    }

    @Test
    fun `should apply F11`() {
        val ship = Ship(Position(17, 3), SOUTH)
        val instruction = Instruction('F', 11)

        val actual = instruction.applyTo(ship)

        assertThat(actual).isEqualTo(Ship(Position(17, -8), SOUTH))
    }

}
