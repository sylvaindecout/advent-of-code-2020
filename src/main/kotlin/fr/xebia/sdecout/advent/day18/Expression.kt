package fr.xebia.sdecout.advent.day18

import fr.xebia.sdecout.advent.day18.Precedence.ADDITION_OVER_PRODUCT
import fr.xebia.sdecout.advent.day18.Precedence.LEFT_TO_RIGHT

data class Expression(
    private val expression: String,
    private val precedence: Precedence
) {

    fun resolve(): Long = if (isSurroundedByParentheses()) removeSurroundingParentheses().resolve()
    else when (precedence) {
        ADDITION_OVER_PRODUCT -> findIndexOf(Operator.PRODUCT) ?: findIndexOf(Operator.ADDITION)
        LEFT_TO_RIGHT -> findIndexOfAny(Operator.PRODUCT, Operator.ADDITION)
    }?.let { indexOfOperator ->
        Operator.parse(expression[indexOfOperator]).resolve(
            Expression(expression.substring(0, indexOfOperator - 1), precedence),
            Expression(expression.substring(indexOfOperator + 2, expression.length), precedence)
        )
    } ?: expression.replace(" ", "").toLong()

    private fun isSurroundedByParentheses() = expression.endsWith(')') && findIndexOfOpeningParenthese() == 0

    private fun findIndexOfOpeningParenthese(): Int? {
        var depth = 0
        expression.dropLast(1).indices.reversed().forEach {
            when (expression[it]) {
                ')' -> depth += 1
                '(' -> if (depth == 0) return it else depth -= 1
            }
        }
        return null
    }

    private fun removeSurroundingParentheses() = Expression(expression.substring(1, expression.length - 1), precedence)

    private fun findIndexOf(operator: Operator) = findIndexOfAny(operator)

    private fun findIndexOfAny(vararg operators: Operator): Int? {
        var depth = 0
        expression.indices.reversed().forEach {
            when (expression[it]) {
                ')' -> depth += 1
                '(' -> depth -= 1
                in operators.map { it.character } -> if (depth == 0) return it
            }
        }
        return null
    }

    override fun toString() = expression

}
