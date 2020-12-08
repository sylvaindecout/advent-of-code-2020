package fr.xebia.sdecout.advent.day8

sealed class ProgramState {

    data class Success(
        val accumulator: Int
    ) : ProgramState()

    data class Pending(
        val accumulator: Int,
        val nextLineIndex: Int
    ) : ProgramState()

}
