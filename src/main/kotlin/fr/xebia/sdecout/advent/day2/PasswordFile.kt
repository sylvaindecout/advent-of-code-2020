package fr.xebia.sdecout.advent.day2

import java.nio.file.Files
import java.nio.file.Path

class PasswordFile(file: Path) {

    private val lines = Files.readAllLines(file)

    fun getNbValidPassword() = lines.filter { isValid(it) }.count()

    private fun isValid(line: String): Boolean {
        val splitLine: List<String> = line.split(" ")
        if (splitLine.size > 3) throw IllegalArgumentException("Unexpected size for $splitLine")
        val occurrences: String = splitLine[0]
        val splitOccurrences: List<String> = occurrences.split("-")
        if (splitOccurrences.size > 2) throw IllegalArgumentException("Unexpected size for $splitOccurrences (in $splitLine)")
        val min: Int = splitOccurrences[0].toInt()
        val max: Int = splitOccurrences[1].toInt()
        val letter: Char = splitLine[1].first()
        val password: String = splitLine[2]

        if (password.length < max) throw IllegalArgumentException("Unexpected size for $password (in $splitLine)")
        return listOf(password[min - 1], password[max - 1])
            .filter { it == letter }.count() == 1
    }

}
