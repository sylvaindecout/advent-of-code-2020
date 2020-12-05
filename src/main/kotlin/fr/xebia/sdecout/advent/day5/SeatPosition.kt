package fr.xebia.sdecout.advent.day5

data class SeatPosition(val row: Int, val column: Int) {

    fun getSeatId(): Int = row * 8 + column

    companion object {
        fun fromCode(code: String): SeatPosition {
            val digits = code.toCharArray()
            if (digits.size != 10) throw IllegalArgumentException("Invalid seat code: $code")

            val row: Int = (0..6).map { digits[it] }
                .fold(Range(0, 127)) { range, digit -> bisectRows(range, digit) }
                .getValue()
            val column: Int = (7..9).map { digits[it] }
                .fold(Range(0, 7)) { range, digit -> bisectColumns(range, digit) }
                .getValue()

            return SeatPosition(row, column)
        }

        private fun bisectRows(range: Range, digit: Char) = when (digit) {
            'B' -> range.getUpperHalf()
            'F' -> range.getLowerHalf()
            else -> throw IllegalArgumentException("Unexpected digit: $digit")
        }

        private fun bisectColumns(range: Range, digit: Char) = when (digit) {
            'L' -> range.getLowerHalf()
            'R' -> range.getUpperHalf()
            else -> throw IllegalArgumentException("Unexpected digit: $digit")
        }
    }

}

