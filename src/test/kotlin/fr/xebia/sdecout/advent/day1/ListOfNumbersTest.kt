package fr.xebia.sdecout.advent.day1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.nio.file.Paths

@Tag("Integration")
class ListOfNumbersTest {

    @Test
    fun `should find combinations summing to 2020`() {
        val inputFile = Paths.get("src/main/resources/day1/example.txt")

        val combination = ListOfNumbers(inputFile).findCombinationSummingTo(2020)

        assertThat(combination).isEqualTo(Triple(979, 366, 675))
    }

}
