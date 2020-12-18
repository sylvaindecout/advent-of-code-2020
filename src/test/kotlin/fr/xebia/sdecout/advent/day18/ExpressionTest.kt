package fr.xebia.sdecout.advent.day18

import fr.xebia.sdecout.advent.day18.Precedence.ADDITION_OVER_PRODUCT
import fr.xebia.sdecout.advent.day18.Precedence.LEFT_TO_RIGHT
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExpressionTest {

    @Test
    fun `should resolve expression without parentheses with left-to-right precedence`() {
        val expression = Expression("1 + 2 * 3 + 4 * 5 + 6", precedence = LEFT_TO_RIGHT)
        assertThat(expression.resolve()).isEqualTo(71)
    }

    @Test
    fun `should resolve expression with parentheses with left-to-right precedence`() {
        val expression = Expression("1 + (2 * 3) + (4 * (5 + 6))", precedence = LEFT_TO_RIGHT)
        assertThat(expression.resolve()).isEqualTo(51)
    }

    @Test
    fun `should resolve expression with redundant parentheses with left-to-right precedence`() {
        val expression = Expression("(1 + 2 * 3)", precedence = LEFT_TO_RIGHT)
        assertThat(expression.resolve()).isEqualTo(9)
    }

    @Test
    fun `should resolve expression without parentheses with precedence of addition over product`() {
        val expression = Expression("1 + 2 * 3 + 4 * 5 + 6", precedence = ADDITION_OVER_PRODUCT)
        assertThat(expression.resolve()).isEqualTo(231)
    }

    @Test
    fun `should resolve expression with parentheses with precedence of addition over product`() {
        val expression = Expression("1 + (2 * 3) + (4 * (5 + 6))", precedence = ADDITION_OVER_PRODUCT)
        assertThat(expression.resolve()).isEqualTo(51)
    }

    @Test
    fun `should resolve expression with redundant parentheses with precedence of addition over product`() {
        val expression = Expression("(1 + 2 * 3)", precedence = ADDITION_OVER_PRODUCT)
        assertThat(expression.resolve()).isEqualTo(9)
    }

    @Test
    fun `should resolve expression with parentheses on both ends with precedence of addition over product`() {
        val expression = Expression("(1 + 2 * 3) + (1 + 2)", precedence = ADDITION_OVER_PRODUCT)
        assertThat(expression.resolve()).isEqualTo(12)
    }

    @Test
    fun `should resolve expression with imbricated parentheses with precedence of addition over product`() {
        val expression = Expression("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2", precedence = ADDITION_OVER_PRODUCT)
        assertThat(expression.resolve()).isEqualTo(23_340)
    }

}
