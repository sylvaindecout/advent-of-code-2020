package fr.xebia.sdecout.advent.day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.nio.file.Paths

@Tag("Integration")
class PassportFileValidatorTest {

    @Test
    fun `should resolve number of valid passports`() {
        val inputFile = Paths.get("src/main/resources/day4/example.txt")

        val nbValidPassports = PassportFileValidator(inputFile).resolveNbValidPassports()

        assertThat(nbValidPassports).isEqualTo(2)
    }

}
