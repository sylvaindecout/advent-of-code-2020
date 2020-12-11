package fr.xebia.sdecout.advent.day11

data class Direction(
    val next: (Position) -> Position
)
