package fr.xebia.sdecout.advent.day10

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class AdapterPathBuilderTest {

    @Test
    fun `should compute product of 1-jolt differences and 3-jolt differences for example #1`() {
        val inputFile = Paths.get("src/main/resources/day10/example.txt")

        val product = AdapterPathBuilder(inputFile).getProductOf1JoltStepsWith3JoltSteps()

        assertThat(product).isEqualTo(35)
    }

    @Test
    fun `should compute product of 1-jolt differences and 3-jolt differences for example #2`() {
        val inputFile = Paths.get("src/main/resources/day10/example-2.txt")

        val product = AdapterPathBuilder(inputFile).getProductOf1JoltStepsWith3JoltSteps()

        assertThat(product).isEqualTo(220)
    }

    @Test
    fun `should find how many arrangements are possible for example #1`() {
        val inputFile = Paths.get("src/main/resources/day10/example.txt")

        val product = AdapterPathBuilder(inputFile).countPossibleArrangements()

        assertThat(product).isEqualTo(8)
    }

    @Test
    fun `should find how many arrangements are possible for example #2`() {
        val inputFile = Paths.get("src/main/resources/day10/example-2.txt")

        val product = AdapterPathBuilder(inputFile).countPossibleArrangements()

        assertThat(product).isEqualTo(19208)
    }

}
