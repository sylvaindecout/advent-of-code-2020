package fr.xebia.sdecout.advent.day7

import java.nio.file.Files.newBufferedReader
import java.nio.file.Path

class Rules(inputFile: Path) {

    private val rules: Map<BagColor, Map<BagColor, Int>> = parse(inputFile)

    fun resolveNbOfIndividualBagsRequiredIn(bagColor: BagColor): Int {
        return resolveNbOfIndividualBagsRequiredFor(bagColor) - 1
    }

    private fun resolveNbOfIndividualBagsRequiredFor(bagColor: BagColor): Int {
        return rules[bagColor]?.let {
            it.map { entry -> resolveNbOfIndividualBagsRequiredFor(entry.key) * entry.value }.sum() + 1
        } ?: 1
    }

    fun bagColorsThatCanEventuallyContainAtLeastOne(bagColor: BagColor): Set<BagColor> {
        return discoverAdjacentLevel(emptySet(), setOf(bagColor))
    }

    private fun discoverAdjacentLevel(accumulatedList: Set<BagColor>, level: Set<BagColor>): Set<BagColor> {
        val adjacentLevel = level.flatMap { bagColorsThatThatCanDirectlyContainAtLeastOne(it) }
        return if (adjacentLevel.isEmpty() || accumulatedList.contains(adjacentLevel)) accumulatedList
        else discoverAdjacentLevel(accumulatedList + adjacentLevel, adjacentLevel.toSet())
    }

    private fun bagColorsThatThatCanDirectlyContainAtLeastOne(containee: BagColor): Set<BagColor> {
        return rules.filterValues { it.containsKey(containee) }.map { it.key }.toSet()
    }

    companion object {
        private fun parse(inputFile: Path): Map<BagColor, Map<BagColor, Int>> {
            val rules = mutableMapOf<BagColor, Map<BagColor, Int>>()
            newBufferedReader(inputFile).useLines { lines ->
                lines.forEach {
                    val splitLine = it.split(" bags contain ")
                    if (splitLine.size != 2) throw IllegalArgumentException("Unexpected line format: $it")
                    rules[BagColor(splitLine[0])] = parseContent(splitLine[1])
                }
            }
            return rules
        }

        private fun parseContent(content: String, formerMap: Map<BagColor, Int> = emptyMap()): Map<BagColor, Int> {
            if (content.startsWith("no")) return emptyMap()
            val quantity = content[0].toString().toInt()
            val nextSeparatorIndex = content.indexOf(", ")
            return if (nextSeparatorIndex == -1) {
                val finalSeparatorIndex = content.indexOf(".")
                parseElement(content.substring(2, finalSeparatorIndex), quantity, formerMap)
            } else {
                parseContent(
                    content.substring(nextSeparatorIndex + 2),
                    parseElement(content.substring(2, nextSeparatorIndex), quantity, formerMap)
                )
            }
        }

        private fun parseElement(bag: String, quantity: Int, formerMap: Map<BagColor, Int>): Map<BagColor, Int> {
            val updatedMap = formerMap.toMutableMap()
            val bagColor = BagColor(bag.substringBefore(" bags").substringBefore(" bag"))
            updatedMap[bagColor] = quantity
            return updatedMap.toMap()
        }
    }
}
