package fr.xebia.sdecout.advent.day10

import java.nio.file.Files.readAllLines
import java.nio.file.Path

class AdapterPathBuilder(inputFile: Path) {

    private val chargingOutlet = JoltageAdapter(outputJoltageRating = 0)
    private val adaptersInTheBag = readAllLines(inputFile)
        .map { it.toInt() }
        .map { JoltageAdapter(outputJoltageRating = it) }
    private val builtInAdapterOfDevice by lazy {
        adaptersInTheBag.maxByOrNull { it.outputJoltageRating }
            ?.let { it.outputJoltageRating + 3 }
            ?.let { JoltageAdapter(outputJoltageRating = it) }
            ?: throw IllegalStateException("No adapters available")
    }

    fun getProductOf1JoltStepsWith3JoltSteps(): Int {
        val adapters: List<JoltageAdapter> = adaptersInTheBag
            .plus(chargingOutlet)
            .plus(builtInAdapterOfDevice)
            .sortedBy { it.outputJoltageRating }
        val differences: List<Int> = adapters
            .map { it.outputJoltageRating }
            .zipWithNext()
            .map { it.second - it.first }
        return differences.count { it == 1 } * differences.count { it == 3 }
    }

    fun countPossibleArrangements(): Long {
        val adapters: List<JoltageAdapter> = adaptersInTheBag
            .plus(builtInAdapterOfDevice)
            .sortedBy { it.outputJoltageRating }
        val nbPathsByAdapter = mutableMapOf(Pair(chargingOutlet, 1L))
        adapters.forEach { adapter ->
            val possibleOrigins = (1..3)
                .map { adapter.outputJoltageRating - it }
                .map { JoltageAdapter(it) }
            nbPathsByAdapter[adapter] = possibleOrigins
                .map { nbPathsByAdapter.getOrDefault(it, 0) }
                .sum()
        }
        return nbPathsByAdapter.getValue(adapters.last())
    }

}
