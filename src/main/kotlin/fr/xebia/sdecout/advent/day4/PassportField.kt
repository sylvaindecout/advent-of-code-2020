package fr.xebia.sdecout.advent.day4

enum class PassportField(val skipped: Boolean = false) {

    byr {
        override fun isValid(value: String) = value.isYearIn(1920..2002)
    },
    iyr {
        override fun isValid(value: String) = value.isYearIn(2010..2020)
    },
    eyr {
        override fun isValid(value: String) = value.isYearIn(2020..2030)
    },
    hgt {
        override fun isValid(value: String) = value.isHeightInCentimeters() || value.isHeightInInches()
    },
    hcl {
        override fun isValid(value: String) = value.matches(Regex("#[0-9a-f]{6}"))
    },
    ecl {
        override fun isValid(value: String) = value in EYE_COLORS
    },
    pid {
        override fun isValid(value: String) = value.matches(Regex("[0-9]{9}"))
    },
    cid(skipped = true) {
        override fun isValid(value: String) = true
    };

    abstract fun isValid(value: String): Boolean

    companion object {
        val EYE_COLORS = setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
        fun requiredFields(): List<PassportField> = values().filter { !it.skipped }
    }

    fun String.isYearIn(range: IntRange) = try {
        toInt() in range
    } catch (ex: NumberFormatException) {
        false
    }

    fun String.isHeightInCentimeters() = this.endsWith("cm") && try {
        this.substring(0, this.length - 2).toInt() in 150..193
    } catch (ex: NumberFormatException) {
        false
    }

    fun String.isHeightInInches() = this.endsWith("in") && try {
        this.substring(0, this.length - 2).toInt() in 59..76
    } catch (ex: NumberFormatException) {
        false
    }

}
