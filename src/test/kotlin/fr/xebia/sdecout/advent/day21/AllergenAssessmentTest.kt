package fr.xebia.sdecout.advent.day21

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class AllergenAssessmentTest {

    @Test
    fun `should count occurrences of safe ingredients`() {
        val input = Paths.get("src/main/resources/day21/example.txt")
        val nbOccurrences = AllergenAssessment(input).countOccurrencesOfSafeIngredients()
        assertThat(nbOccurrences).isEqualTo(5)
    }

    @Test
    fun `should generate canonical dangerous ingredient list`() {
        val input = Paths.get("src/main/resources/day21/example.txt")
        val canonicalDangerousIngredientList = AllergenAssessment(input).generateCanonicalDangerousIngredientList()
        assertThat(canonicalDangerousIngredientList).isEqualTo("mxmxvkd,sqjhc,fvjkl")
    }

}
