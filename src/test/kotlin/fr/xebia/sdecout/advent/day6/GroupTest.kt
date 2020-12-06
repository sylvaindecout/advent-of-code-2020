package fr.xebia.sdecout.advent.day6

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GroupTest {

    @Test
    fun `should get characters with any positive answer`() {
        val group = Group(listOf(
                Person("ab"),
                Person("ac")
        ))
        assertThat(group.charactersWithAnyPositiveAnswer).containsExactly('a', 'b', 'c')
    }

    @Test
    fun `should get characters with all positive answers`() {
        val group = Group(listOf(
                Person("ab"),
                Person("ac")
        ))
        assertThat(group.charactersWithAllPositiveAnswers).containsExactly('a')
    }

}
