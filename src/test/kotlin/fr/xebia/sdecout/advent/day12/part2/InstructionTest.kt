package fr.xebia.sdecout.advent.day12.part2

import fr.xebia.sdecout.advent.day12.Position
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InstructionTest {

    @Test
    fun `should apply F10`() {
        val ship = Ship(
            position = Position(0, 0),
            relativeWaypointPosition = Position(10, 1)
        )
        val instruction = Instruction('F', 10)

        val actual = instruction.applyTo(ship)

        assertThat(actual).isEqualTo(Ship(
            position = Position(100, 10),
            relativeWaypointPosition = Position(10, 1)
        ))
    }

    @Test
    fun `should apply N3`() {
        val ship = Ship(
            position = Position(100, 10),
            relativeWaypointPosition = Position(10, 1)
        )
        val instruction = Instruction('N', 3)

        val actual = instruction.applyTo(ship)

        assertThat(actual).isEqualTo(Ship(
            position = Position(100, 10),
            relativeWaypointPosition = Position(10, 4)
        ))
    }

    @Test
    fun `should apply F7`() {
        val ship = Ship(
            position = Position(100, 10),
            relativeWaypointPosition = Position(10, 4)
        )
        val instruction = Instruction('F', 7)

        val actual = instruction.applyTo(ship)

        assertThat(actual).isEqualTo(Ship(
            position = Position(170, 38),
            relativeWaypointPosition = Position(10, 4)
        ))
    }

    @Test
    fun `should apply R90`() {
        val ship = Ship(
            position = Position(170, 38),
            relativeWaypointPosition = Position(10, 4)
        )
        val instruction = Instruction('R', 90)

        val actual = instruction.applyTo(ship)

        assertThat(actual).isEqualTo(Ship(
            position = Position(170, 38),
            relativeWaypointPosition = Position(4, -10)
        ))
    }

    @Test
    fun `should apply F11`() {
        val ship = Ship(
            position = Position(170, 38),
            relativeWaypointPosition = Position(4, -10)
        )
        val instruction = Instruction('F', 11)

        val actual = instruction.applyTo(ship)

        assertThat(actual).isEqualTo(Ship(
            position = Position(214, -72),
            relativeWaypointPosition = Position(4, -10)
        ))
    }

}
