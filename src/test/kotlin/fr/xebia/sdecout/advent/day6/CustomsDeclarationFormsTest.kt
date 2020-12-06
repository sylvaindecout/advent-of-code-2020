package fr.xebia.sdecout.advent.day6

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class CustomsDeclarationFormsTest {

    @Test
    fun `should count positive answers by group`() {
        val inputFile = Paths.get("src/main/resources/day6/example.txt")

        val positiveAnswersByGroup = CustomsDeclarationForms(inputFile).countPositiveAnswersByGroup()

        assertThat(positiveAnswersByGroup).isEqualTo(6)
    }

}
