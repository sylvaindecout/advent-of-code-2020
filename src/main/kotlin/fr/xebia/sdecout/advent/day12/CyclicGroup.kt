package fr.xebia.sdecout.advent.day12

data class CyclicGroup<T> (val orderedValues: List<T>) {

    fun after(former: T): T {
        if (former !in orderedValues) throw IllegalArgumentException("Unknown value: $former")
        val formerIndex = orderedValues.indexOf(former)
        val nextIndex = if (formerIndex == orderedValues.size - 1) 0 else formerIndex + 1
        return orderedValues[nextIndex]
    }

    fun before(former: T): T {
        if (former !in orderedValues) throw IllegalArgumentException("Unknown value: $former")
        val formerIndex = orderedValues.indexOf(former)
        val nextIndex = if (formerIndex == 0) orderedValues.size - 1 else formerIndex - 1
        return orderedValues[nextIndex]
    }

}
