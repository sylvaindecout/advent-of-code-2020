package fr.xebia.sdecout.advent.day11

import fr.xebia.sdecout.advent.day11.Mode.ADJACENT_SEATS
import fr.xebia.sdecout.advent.day11.Mode.NEXT_VISIBLE_SEATS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class SeatingTest {

    @Test
    fun `should count number of occupied seats when seating stabilizes - take adjacent seats into account`() {
        val inputFile = Paths.get("src/main/resources/day11/example.txt")

        val nbOccupiedSeats = Seating(inputFile).updateUntilStabilized(mode = ADJACENT_SEATS, tolerance = 4).countOccupiedSeats()

        assertThat(nbOccupiedSeats).isEqualTo(37)
    }

    @Test
    fun `should count number of occupied seats when seating stabilizes - take next visible seats into account`() {
        val inputFile = Paths.get("src/main/resources/day11/example.txt")

        val nbOccupiedSeats = Seating(inputFile).updateUntilStabilized(mode = NEXT_VISIBLE_SEATS, tolerance = 5).countOccupiedSeats()

        assertThat(nbOccupiedSeats).isEqualTo(26)
    }

}
