package fr.xebia.sdecout.advent.day8

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.fail
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class ProgramTest {

    @Test
    fun `should return value of the accumulator after every line has been executed once`() {
        val inputFile = Paths.get("src/main/resources/day8/example.txt")
        when (val executionState = Program(inputFile).execute()) {
            is ProgramState.Pending -> assertThat(executionState.accumulator).isEqualTo(5)
            else -> fail("Unexpected state: $executionState")
        }
    }

    @Test
    fun `should return value of the accumulator when program execution completes successfully`() {
        val inputFile = Paths.get("src/main/resources/day8/example-2.txt")
        when (val executionState = Program(inputFile).execute()) {
            is ProgramState.Success -> assertThat(executionState.accumulator).isEqualTo(8)
            else -> fail("Unexpected state: $executionState")
        }
    }

}
