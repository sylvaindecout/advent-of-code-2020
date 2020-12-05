package fr.xebia.sdecout.advent.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.nio.file.Paths

@Tag("Integration")
class AreaTest {

    @Test
    fun `should get number of trees encountered for slopes #1`() {
        val inputFile = Paths.get("src/main/resources/day3/example.txt")
        val slope = Slope({ x: Int -> x + 1 }, { y: Int -> y + 1 })

        val nbOfTreesEncountered = Area(inputFile).getNbOfTreesEncountered(slope)

        assertThat(nbOfTreesEncountered).isEqualTo(2)
    }

    @Test
    fun `should get number of trees encountered for slopes #2`() {
        val inputFile = Paths.get("src/main/resources/day3/example.txt")
        val slope = Slope({ x: Int -> x + 3 }, { y: Int -> y + 1 })

        val nbOfTreesEncountered = Area(inputFile).getNbOfTreesEncountered(slope)

        assertThat(nbOfTreesEncountered).isEqualTo(7)
    }

    @Test
    fun `should get number of trees encountered for slopes #3`() {
        val inputFile = Paths.get("src/main/resources/day3/example.txt")
        val slope = Slope({ x: Int -> x + 5 }, { y: Int -> y + 1 })

        val nbOfTreesEncountered = Area(inputFile).getNbOfTreesEncountered(slope)

        assertThat(nbOfTreesEncountered).isEqualTo(3)
    }

    @Test
    fun `should get number of trees encountered for slopes #4`() {
        val inputFile = Paths.get("src/main/resources/day3/example.txt")
        val slope = Slope({ x: Int -> x + 7 }, { y: Int -> y + 1 })

        val nbOfTreesEncountered = Area(inputFile).getNbOfTreesEncountered(slope)

        assertThat(nbOfTreesEncountered).isEqualTo(4)
    }

    @Test
    fun `should get number of trees encountered for slopes #5`() {
        val inputFile = Paths.get("src/main/resources/day3/example.txt")
        val slope = Slope({ x: Int -> x + 1 }, { y: Int -> y + 2 })

        val nbOfTreesEncountered = Area(inputFile).getNbOfTreesEncountered(slope)

        assertThat(nbOfTreesEncountered).isEqualTo(2)
    }

}
