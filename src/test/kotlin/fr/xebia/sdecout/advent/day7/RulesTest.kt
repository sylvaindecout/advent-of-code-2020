package fr.xebia.sdecout.advent.day7

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class RulesTest {

    @Test
    fun `should resolve number of individual bags required in a Shiny Gold bag with example #1`() {
        val inputFile = Paths.get("src/main/resources/day7/example.txt")

        val numberOfRequiredBags = Rules(inputFile).resolveNbOfIndividualBagsRequiredIn(BagColor("shiny gold"))

        assertThat(numberOfRequiredBags).isEqualTo(32)
    }

    @Test
    fun `should resolve number of individual bags required in a Shiny Gold bag with example #2`() {
        val inputFile = Paths.get("src/main/resources/day7/example-2.txt")

        val numberOfRequiredBags = Rules(inputFile).resolveNbOfIndividualBagsRequiredIn(BagColor("shiny gold"))

        assertThat(numberOfRequiredBags).isEqualTo(126)
    }

    @Test
    fun `should get bag colors that can eventually contain at least one Shiny Gold bag`() {
        val inputFile = Paths.get("src/main/resources/day7/example.txt")

        val eventualContainers = Rules(inputFile).bagColorsThatCanEventuallyContainAtLeastOne(BagColor("shiny gold"))

        assertThat(eventualContainers).hasSize(4)
    }

}
