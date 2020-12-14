package fr.xebia.sdecout.advent.day14

import kotlin.math.pow

data class Mask(val mask: String) {

    fun applyTo(decimalValue: Long): Long {
        val binaryValue = decimalValue.toString(2).padStart(mask.length, '0')
        return mask.indices.fold(0) { result, i ->
            val bit: Int = when (mask[i]) {
                '0' -> 0
                '1' -> 1
                'X' -> Character.getNumericValue(binaryValue[i])
                else -> throw IllegalArgumentException("Unexpected character: ${mask[i]}")
            }
            result + bit * 2.0.pow(mask.length - i - 1).toLong()
        }
    }

    fun resolvePossibleValuesFor(decimalValue: Long): List<Long> {
        val binaryValue = decimalValue.toString(2).padStart(mask.length, '0')
        val valueWithFloatingBits = binaryValue.zip(mask).map {
            when (it.second) {
                '0' -> it.first
                '1' -> '1'
                'X' -> 'X'
                else -> throw IllegalArgumentException("Unexpected character: ${it.second}")
            }
        }.let { String(it.toCharArray()) }
        return resolve(valueWithFloatingBits)
    }

    private fun resolve(valueWithFloatingBits: String): List<Long> {
        if (valueWithFloatingBits.isEmpty()) return emptyList()
        val values: List<Long> = when (valueWithFloatingBits[valueWithFloatingBits.length - 1]) {
            '0' -> listOf(0)
            '1' -> listOf(1)
            'X' -> listOf(0, 1)
            else -> throw IllegalArgumentException("Unexpected character: ${valueWithFloatingBits[valueWithFloatingBits.length - 1]}")
        }
        return resolve(valueWithFloatingBits.dropLast(1)).let { possibleValues ->
            if (possibleValues.isEmpty()) values
            else values.flatMap { value -> possibleValues.map { it * 2 + value } }
        }
    }

}
