package fr.xebia.sdecout.advent.day8

class ProgramFixer(private val initialProgram: Program) {

    fun fix(): ProgramState.Success? {
        for (index in initialProgram.instructions.indices) {
            val currentInstruction = initialProgram.instructions[index]
            tryFixing(currentInstruction)?.let {
                val variation = Program(replaceInstruction(index, it))
                val result = variation.execute()
                if (result is ProgramState.Success) return result
            }
        }
        return null
    }

    private fun tryFixing(currentInstruction: Instruction) = when (currentInstruction) {
        is Instruction.Jump -> Instruction.NoOperation(currentInstruction.value)
        is Instruction.NoOperation -> Instruction.Jump(currentInstruction.value)
        else -> null
    }

    private fun replaceInstruction(index: Int, it: Instruction): List<Instruction> {
        val instructionsWithFix = initialProgram.instructions.toMutableList()
        instructionsWithFix[index] = it
        return instructionsWithFix.toList()
    }

}
