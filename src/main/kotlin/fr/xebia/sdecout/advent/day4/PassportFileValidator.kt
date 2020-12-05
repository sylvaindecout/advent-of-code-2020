package fr.xebia.sdecout.advent.day4

import java.nio.file.Files.newBufferedReader
import java.nio.file.Path

class PassportFileValidator(file: Path) {

    private val passports = parse(file)

    fun resolveNbValidPassports() = passports.count { it.isCompleteAndValid() }

    companion object {
        fun parse(file: Path): List<Passport> {
            val passports = mutableListOf<Passport>()
            val selectedLines = mutableListOf<String>()
            newBufferedReader(file).useLines { allLines ->
                allLines.forEach { currentLine ->
                    if (currentLine.isEmpty()) {
                        passports.add(Passport(selectedLines.toList()))
                        selectedLines.clear()
                    } else {
                        selectedLines.add(currentLine)
                    }
                }
            }
            passports.add(Passport(selectedLines.toList()))
            return passports
        }
    }

}
