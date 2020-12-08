package fr.xebia.sdecout.advent.day8

sealed class Instruction {

    data class Accumulate(val value: Int) : Instruction()
    data class Jump(val value: Int) : Instruction()
    data class NoOperation(val value: Int) : Instruction()

    companion object {
        fun parse(line: String): Instruction {
            val splitLine = line.split(" ")
            if (splitLine.size != 2) throw IllegalArgumentException("Line has invalid format: $line")
            return when (splitLine[0]) {
                "acc" -> Accumulate(splitLine[1].toInt())
                "jmp" -> Jump(splitLine[1].toInt())
                "nop" -> NoOperation(splitLine[1].toInt())
                else -> throw IllegalArgumentException("Line has invalid format: $line")
            }
        }
    }

}
