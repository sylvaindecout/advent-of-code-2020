package fr.xebia.sdecout.advent.day23

class Circle(orderedElements: List<Cup>) {

    private val index = orderedElements.toIndex()

    private fun <T> List<T>.toIndex(): Map<T, LLNode<T>> {
        val index = mutableMapOf<T, LLNode<T>>()
        val firstElement = this[0]
        val lastNode: LLNode<T> = this.fold(LLNode(data = firstElement, next = null)) { previousNode, element ->
            LLNode(data = element, next = null).also { currentNode ->
                index[element] = currentNode
                previousNode.next = currentNode
            }
        }
        lastNode.next = index[firstElement]
        return index.toMap()
    }

    fun nodeFor(element: Cup) = index[element]!!

    fun startingFrom(element: Cup) = generateSequence(index[element]) {
        if (it.next!!.data == element) null else it.next
    }.map { it.data }

}
