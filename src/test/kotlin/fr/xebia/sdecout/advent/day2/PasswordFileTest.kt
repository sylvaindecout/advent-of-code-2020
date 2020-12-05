package fr.xebia.sdecout.advent.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.nio.file.Paths

@Tag("Integration")
class PasswordFileTest {

    @Test
    fun `should resolve number of valid passwords`() {
        val inputFile = Paths.get("src/main/resources/day2/example.txt")

        val nbValidPasswords = PasswordFile(inputFile).getNbValidPassword()

        assertThat(nbValidPasswords).isEqualTo(1)
    }

}
