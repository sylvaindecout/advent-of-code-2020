package fr.xebia.sdecout.advent.day14

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class InitializationProgramTest{

    @Test
    fun `should initialize memory in V1`(){
        val inputFile = Paths.get("src/main/resources/day14/example.txt")

        val memory = InitializationProgram.V1(inputFile).execute()

        assertThat(memory.values.sum()).isEqualTo(165)
    }

    @Test
    fun `should initialize memory in V2`(){
        val inputFile = Paths.get("src/main/resources/day14/example-2.txt")

        val memory = InitializationProgram.V2(inputFile).execute()

        assertThat(memory.values.sum()).isEqualTo(208)
    }

}
