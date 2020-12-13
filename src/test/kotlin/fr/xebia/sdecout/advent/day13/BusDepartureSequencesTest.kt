package fr.xebia.sdecout.advent.day13

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class BusDepartureSequencesTest {

    @Test
    fun `should find earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list`() {
        val inputFile = Paths.get("src/main/resources/day13/example.txt")
        val nextBus = BusDepartureSequences(inputFile).findEarliestTimestampWithOffsetsMatchingPositionsInTheList()
        assertThat(nextBus).isEqualTo(1068781)
    }

    @Test
    fun `should find earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list - example #2`() {
        val constraints = listOf(
            Constraint(busId = 17, offset = 0),
            Constraint(busId = 13, offset = -2),
            Constraint(busId = 19, offset = -3)
        )
        val nextBus = BusDepartureSequences(constraints).findEarliestTimestampWithOffsetsMatchingPositionsInTheList()
        assertThat(nextBus).isEqualTo(3417)
    }

    @Test
    fun `should find earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list - example #3`() {
        val constraints = listOf(
            Constraint(busId = 67, offset = 0),
            Constraint(busId = 7, offset = -1),
            Constraint(busId = 59, offset = -2),
            Constraint(busId = 61, offset = -3)
        )
        val nextBus = BusDepartureSequences(constraints).findEarliestTimestampWithOffsetsMatchingPositionsInTheList()
        assertThat(nextBus).isEqualTo(754018)
    }

    @Test
    fun `should find earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list - example #4`() {
        val constraints = listOf(
            Constraint(busId = 67, offset = 0),
            Constraint(busId = 7, offset = -2),
            Constraint(busId = 59, offset = -3),
            Constraint(busId = 61, offset = -4)
        )
        val nextBus = BusDepartureSequences(constraints).findEarliestTimestampWithOffsetsMatchingPositionsInTheList()
        assertThat(nextBus).isEqualTo(779210)
    }

    @Test
    fun `should find earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list - example #5`() {
        val constraints = listOf(
            Constraint(busId = 67, offset = 0),
            Constraint(busId = 7, offset = -1),
            Constraint(busId = 59, offset = -3),
            Constraint(busId = 61, offset = -4)
        )
        val nextBus = BusDepartureSequences(constraints).findEarliestTimestampWithOffsetsMatchingPositionsInTheList()
        assertThat(nextBus).isEqualTo(1261476)
    }

    @Test
    fun `should find earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list - example #6`() {
        val constraints = listOf(
            Constraint(busId = 1789, offset = 0),
            Constraint(busId = 37, offset = -1),
            Constraint(busId = 47, offset = -2),
            Constraint(busId = 1889, offset = -3)
        )
        val nextBus = BusDepartureSequences(constraints).findEarliestTimestampWithOffsetsMatchingPositionsInTheList()
        assertThat(nextBus).isEqualTo(1202161486)
    }

}
