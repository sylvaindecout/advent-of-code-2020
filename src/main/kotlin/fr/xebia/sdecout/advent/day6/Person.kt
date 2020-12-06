package fr.xebia.sdecout.advent.day6

data class Person(val positiveAnswers: List<Char>) {
    constructor(line: String) : this(line.toCharArray().toList())
}
