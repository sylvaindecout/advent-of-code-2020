package fr.xebia.sdecout.advent.day6

import java.nio.file.Files.newBufferedReader
import java.nio.file.Path

class CustomsDeclarationForms(file: Path) {

    private val groups = parse(file)

    fun countPositiveAnswersByGroup() = groups.sumBy { it.charactersWithAllPositiveAnswers.count() }

    companion object {
        fun parse(file: Path): List<Group> {
            val groups: MutableList<Group> = mutableListOf()
            val selectedLines: MutableList<String> = mutableListOf()
            newBufferedReader(file).useLines {
                it.forEach { currentLine ->
                    if (currentLine.isEmpty()) {
                        groups.add(Group.parse(selectedLines))
                        selectedLines.clear()
                    } else {
                        selectedLines.add(currentLine)
                    }
                }
            }
            groups.add(Group.parse(selectedLines))
            return groups
        }
    }

}
