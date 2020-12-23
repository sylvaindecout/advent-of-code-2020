package fr.xebia.sdecout.advent.day23

class Game(
    input: String,
    nbCups: Int,
    private val nbMoves: Int
) {

    private val cups = input
        .map { it.toString().toInt() }
        .let { list -> list.complementTo(nbCups).map { Cup(it) } }
    private val circle = Circle(cups)

    private val firstCup by lazy { cups[0] }

    fun play(): Sequence<Cup> {
        (1..nbMoves).fold(circle.nodeFor(firstCup)) { currentCup, _ ->
            currentCup.isolateNext(nbElements = 3).let {
                val destinationCup = currentCup.findDestination(isolatedElements = it)
                it.restoreAfter(circle.nodeFor(destinationCup))
            }
            currentCup.next!!
        }
        return circle.startingFrom(Cup(1))
    }

    private fun <T> List<LLNode<T>>.restoreAfter(destination: LLNode<T>) {
        this.last().next = destination.next
        destination.next = this.first()
    }

    private fun LLNode<Cup>.findDestination(isolatedElements: List<LLNode<Cup>>) = findNextValueBelow(
        value = this.data.label,
        invalidValues = isolatedElements.map { it.data.label }
    ).let { Cup(it) }

    private fun findNextValueBelow(value: Int, invalidValues: Collection<Int>): Int =
        (if (value == 1) cups.size else value - 1).let { nextValue ->
            if (nextValue in invalidValues) findNextValueBelow(nextValue, invalidValues)
            else nextValue
        }

    private fun <T> LLNode<T>.isolateNext(nbElements: Int) = (1 until nbElements)
        .fold(listOf(this.next!!)) { list, _ -> list + list.last().next!! }
        .also { this.next = it.last().next }

    private fun List<Int>.complementTo(value: Int) = this + (this.maxOrNull()
        ?.let { it + 1..value }
        ?.toList()
        ?: throw IllegalArgumentException("invalid"))

}
