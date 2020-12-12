package fr.xebia.sdecout.advent.day12

enum class Orientation {

    NORTH {
        override fun moveForward(position: Position) = Position(position.x, position.y + 1)
    },
    EAST {
        override fun moveForward(position: Position) = Position(position.x + 1, position.y)
    },
    WEST {
        override fun moveForward(position: Position) = Position(position.x - 1, position.y)
    },
    SOUTH {
        override fun moveForward(position: Position) = Position(position.x, position.y - 1)
    };

    companion object {
        private val orderedValues = CyclicGroup(listOf(NORTH, WEST, SOUTH, EAST))
    }

    abstract fun moveForward(position: Position): Position

    fun moveForward(position: Position, units: Int) = (0 until units).fold(position) { pos, _ -> moveForward(pos) }

    fun rotateLeft(angle: Int) = (0 until angle / 90).fold(this) { orientation, _ -> orderedValues.after(orientation) }

    fun rotateRight(angle: Int) = (0 until angle / 90).fold(this) { orientation, _ -> orderedValues.before(orientation) }

}
