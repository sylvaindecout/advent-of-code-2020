package fr.xebia.sdecout.advent.day6

data class Group(val persons: List<Person>) {

    val charactersWithAnyPositiveAnswer by lazy {
        persons.flatMap { it.positiveAnswers }.distinct()
    }

    val charactersWithAllPositiveAnswers by lazy {
        charactersWithAnyPositiveAnswer.filter { question ->
            persons.all { it.positiveAnswers.contains(question) }
        }
    }

    companion object {
        fun parse(lines: List<String>) = Group(lines.map { Person(it) })
    }

}

