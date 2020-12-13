package fr.xebia.sdecout.advent.day13

sealed class Bus {

    abstract fun departsAt(time: Long): Boolean

    object OutOfService : Bus() {
        override fun departsAt(time: Long) = true
    }

    data class Active(val id: Long) : Bus() {
        fun nextDepartureTime(earliestDepartureTime: Long) = (earliestDepartureTime / id + 1) * id
        override fun departsAt(time: Long) = time % id == 0L
    }

    companion object {
        fun parse(value: String) = if (value == "x") OutOfService else Active(value.toLong())
    }

}
