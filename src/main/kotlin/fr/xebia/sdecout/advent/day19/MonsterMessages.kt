package fr.xebia.sdecout.advent.day19

import java.nio.file.Files.readAllLines
import java.nio.file.Path

class MonsterMessages(
    val rules: Rules,
    val messages: List<String>
) {

    val validMessages by lazy { messages.filter { rules.validates(it) } }

    fun fix() = MonsterMessages(
        rules = rules.fix(),
        messages = messages
    )

    companion object {
        fun parse(inputFile: Path) = readAllLines(inputFile).let { lines ->
            lines.indexOfFirst { it.isEmpty() }.let { breakLineIndex ->
                MonsterMessages(
                    rules = Rules.parse(lines.subList(0, breakLineIndex)),
                    messages = lines.subList(breakLineIndex + 1, lines.size)
                )
            }
        }
    }

}
