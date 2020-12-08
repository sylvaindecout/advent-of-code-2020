package fr.xebia.sdecout.advent.day8

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class ProgramFixerTest {

    @Test
    fun `should fix corrupted program`() {
        val inputFile = Paths.get("src/main/resources/day8/example.txt")

        val initialProgram = Program(inputFile)
        val result = ProgramFixer(initialProgram).fix()

        assertThat(result?.accumulator).isEqualTo(8)
    }

}
