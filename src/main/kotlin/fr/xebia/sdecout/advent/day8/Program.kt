package fr.xebia.sdecout.advent.day8

import java.nio.file.Files.readAllLines
import java.nio.file.Path

class Program(val instructions: List<Instruction>) {

    constructor(inputFile: Path) : this(parse(inputFile))

    fun execute(
        state: ProgramState = ProgramState.Pending(0, 0),
        executedLineIndices: Set<Int> = emptySet()
    ): ProgramState = when (state) {
        is ProgramState.Success -> state
        is ProgramState.Pending ->
            if (executedLineIndices.contains(state.nextLineIndex)) state
            else execute(executeNext(state), executedLineIndices + state.nextLineIndex)
    }

    private fun executeNext(state: ProgramState.Pending): ProgramState {
        if (instructions.size <= state.nextLineIndex) {
            return ProgramState.Success(state.accumulator)
        } else {
            val instruction: Instruction = instructions[state.nextLineIndex]
            return ProgramState.Pending(
                accumulator = state.accumulator + when (instruction) {
                    is Instruction.Accumulate -> instruction.value
                    is Instruction.Jump -> 0
                    is Instruction.NoOperation -> 0
                },
                nextLineIndex = when (instruction) {
                    is Instruction.Accumulate -> state.nextLineIndex + 1
                    is Instruction.Jump -> state.nextLineIndex + instruction.value
                    is Instruction.NoOperation -> state.nextLineIndex + 1
                }
            )
        }
    }

    companion object {
        fun parse(inputFile: Path): List<Instruction> = readAllLines(inputFile).map { Instruction.parse(it) }
    }

}
