package fr.xebia.sdecout.advent.day14

import java.nio.file.Files.newBufferedReader
import java.nio.file.Path

sealed class InitializationProgram {

    class V1(private val inputFile: Path) : InitializationProgram() {

        private var mask: Mask? = null
        private val memory = mutableMapOf<Long, Long>()

        fun execute(): Map<Long, Long> {
            newBufferedReader(inputFile).useLines { lines -> lines.forEach { processLine(it) } }
            return memory.toMap()
        }

        private fun processLine(line: String) =
            if (line.startsWith("mask = ")) processMaskUpdateLine(line)
            else processMemoryUpdateLine(line)

        private fun processMaskUpdateLine(line: String) {
            mask = Mask(line.replace("mask = ", ""))
        }

        private fun processMemoryUpdateLine(line: String) {
            line.split(" = ").let { splitLine ->
                val position = splitLine[0]
                    .replace("mem[", "")
                    .replace("]", "")
                    .toLong()
                val value = splitLine[1].toLong()
                    .let { mask!!.applyTo(it) }
                memory[position] = value
            }
        }
    }

    class V2(private val inputFile: Path) : InitializationProgram() {

        private var mask: Mask? = null
        private val memory = mutableMapOf<Long, Long>()

        fun execute(): Map<Long, Long> {
            newBufferedReader(inputFile).useLines { lines -> lines.forEach { processLine(it) } }
            return memory.toMap()
        }

        private fun processLine(line: String) =
            if (line.startsWith("mask = ")) processMaskUpdateLine(line)
            else processMemoryUpdateLine(line)

        private fun processMaskUpdateLine(line: String) {
            mask = Mask(line.replace("mask = ", ""))
        }

        private fun processMemoryUpdateLine(line: String) {
            line.split(" = ").let { splitLine ->
                val position = splitLine[0]
                    .replace("mem[", "")
                    .replace("]", "")
                    .toLong()
                val value = splitLine[1].toLong()
                position
                    .let { mask!!.resolvePossibleValuesFor(it) }
                    .forEach { memory[it] = value }
            }
        }
    }


}
