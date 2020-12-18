package fr.xebia.sdecout.advent.day18

enum class Operator(val character: Char) {

    ADDITION('+') {
        override fun resolve(left: Expression, right: Expression) = right.resolve() + left.resolve()
    },
    PRODUCT('*') {
        override fun resolve(left: Expression, right: Expression) = right.resolve() * left.resolve()
    };

    abstract fun resolve(left: Expression, right: Expression): Long

    companion object {
        fun parse(character: Char) = values().find { it.character == character }
            ?: throw IllegalArgumentException("Character does not match any operation: $character")
    }

}
