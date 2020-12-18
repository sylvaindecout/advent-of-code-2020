package fr.xebia.sdecout.advent.day18

import fr.xebia.sdecout.advent.day18.Precedence.ADDITION_OVER_PRODUCT
import fr.xebia.sdecout.advent.day18.Precedence.LEFT_TO_RIGHT
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.nio.file.Paths

@Tag("Integration")
class HomeworkTest {

    @Test
    fun `should resolve operations with left-to-right precedence`() {
        val input = Paths.get("src/main/resources/day18/example.txt")

        val results = Homework(input, precedence = LEFT_TO_RIGHT).resolve()

        assertThat(results).containsExactly(
            26, 437, 12_240, 13_632
        )
    }

    @Test
    fun `should resolve operations with precedence of addition over product`() {
        val input = Paths.get("src/main/resources/day18/example.txt")

        val results = Homework(input, precedence = ADDITION_OVER_PRODUCT).resolve()

        assertThat(results).containsExactly(
            46, 1_445, 669_060, 23_340
        )
    }

}
