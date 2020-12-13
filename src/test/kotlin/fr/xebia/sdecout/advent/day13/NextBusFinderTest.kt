package fr.xebia.sdecout.advent.day13

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class NextBusFinderTest {

    @Test
    fun `should find next bus`() {
        val inputFile = Paths.get("src/main/resources/day13/example.txt")
        val nextBus = NextBusFinder(inputFile).findNextBus()
        assertThat(nextBus).isEqualTo(NextBus(59, 5))
    }

}
