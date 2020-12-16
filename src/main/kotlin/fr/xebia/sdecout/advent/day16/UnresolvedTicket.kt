package fr.xebia.sdecout.advent.day16

data class UnresolvedTicket(val values: List<Int>) {
    companion object {
        fun parse(line: String) = line.split(",")
            .map { it.toInt() }
            .let { UnresolvedTicket(it) }
    }
}
