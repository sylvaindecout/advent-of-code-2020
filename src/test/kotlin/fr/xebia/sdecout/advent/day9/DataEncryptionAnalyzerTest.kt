package fr.xebia.sdecout.advent.day9

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class DataEncryptionAnalyzerTest {

    @Test
    fun `should find first number necessarily after preamble`() {
        val analyzer = DataEncryptionAnalyzer(
            inputFile = Paths.get("src/main/resources/day9/example.txt"),
            preambleSize = 5
        )

        val firstNumberAfterPreamble = analyzer.findFirstNumberNecessarilyAfterPreamble()

        assertThat(firstNumberAfterPreamble).isEqualTo(127)
    }

    @Test
    fun `should find encryption weakness`() {
        val analyzer = DataEncryptionAnalyzer(
            inputFile = Paths.get("src/main/resources/day9/example.txt"),
            preambleSize = 5
        )

        val encryptionWeakness = analyzer.findEncryptionWeakness()

        assertThat(encryptionWeakness).isEqualTo(62)
    }

}
