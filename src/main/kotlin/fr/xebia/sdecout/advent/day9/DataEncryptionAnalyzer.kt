package fr.xebia.sdecout.advent.day9

import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.ArrayBlockingQueue

class DataEncryptionAnalyzer(inputFile: Path, val preambleSize: Int = 25) {

    private val lines = Files.readAllLines(inputFile)

    fun findEncryptionWeakness() = findFirstNumberNecessarilyAfterPreamble()?.let {
        val sequence = findSequenceSummingTo(it)
        val min = sequence.minOrNull() ?: throw IllegalStateException("Not found")
        val max = sequence.maxOrNull() ?: throw IllegalStateException("Not found")
        min + max
    }

    private fun findSequenceSummingTo(value: Int) = (0 until lines.indexOf(value.toString()))
        .mapNotNull { findSequenceSummingTo(it, value, emptyList()) }
        .first()

    private fun findSequenceSummingTo(currentIndex: Int, value: Int, sequence: List<Int>): List<Int>? {
        val updatedSequence = sequence.toMutableList()
        updatedSequence.add(lines[currentIndex].toInt())
        val sum = updatedSequence.sum()
        return when {
            sum < value -> findSequenceSummingTo(currentIndex + 1, value, updatedSequence.toList())
            sum == value -> updatedSequence.toList()
            else -> null
        }
    }

    fun findFirstNumberNecessarilyAfterPreamble(): Int? {
        val queue = ArrayBlockingQueue<Int>(preambleSize + 1)
        for (i in lines.indices) {
            val number = lines[i].toInt()
            if (i in 0 until preambleSize || number in possibleSums(queue.toList())) {
                queue.put(number)
                if (queue.remainingCapacity() == 0) queue.remove()
            } else {
                return number
            }
        }
        return null
    }

    private fun possibleSums(previousNumbers: List<Int>) = previousNumbers.indices.flatMap { i ->
        (i until previousNumbers.size).map { j ->
            previousNumbers[i] + previousNumbers[j]
        }
    }

}
