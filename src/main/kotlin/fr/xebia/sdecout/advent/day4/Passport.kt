package fr.xebia.sdecout.advent.day4

data class Passport(val lines: List<String>) {

    fun isCompleteAndValid(): Boolean {
        val validKeys = lines.flatMap { getValidFields(it) }
        println("Valid keys: $validKeys")
        return PassportField.requiredFields().all { validKeys.contains(it) }
    }

    private fun getValidFields(line: String): List<PassportField> {
        val splitLine: List<String> = line.split(' ')
        return splitLine.mapNotNull { filterValidField(it) }
    }

    private fun filterValidField(entry: String): PassportField? {
        val splitEntry: List<String> = entry.split(':')
        val key: PassportField = PassportField.valueOf(splitEntry[0])
        return if (key.isValid(splitEntry[1])) key else null
    }

}
