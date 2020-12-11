package fr.xebia.sdecout.advent.day11

enum class Seat(val code: Char) {

    OCCUPIED('#'),
    EMPTY('L'),
    FLOOR('.');

    companion object {
        fun parse(code: Char) = values().first { it.code == code }
    }

}
