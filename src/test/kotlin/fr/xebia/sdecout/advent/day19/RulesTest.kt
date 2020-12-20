package fr.xebia.sdecout.advent.day19

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RulesTest {

    @Test
    fun `should build regex for rule 0`() {
        val rules = Rules(
            listOf(
                Rule.SubRules(0, listOf(listOf(4, 1, 5))),
                Rule.SubRules(1, listOf(listOf(2, 3), listOf(3, 2))),
                Rule.SubRules(2, listOf(listOf(4, 4), listOf(5, 5))),
                Rule.SubRules(3, listOf(listOf(4, 5), listOf(5, 4))),
                Rule.SingleCharacter(4, 'a'),
                Rule.SingleCharacter(5, 'b')
            )
        )

        val regex = rules.buildRegexForRule(0)

        assertThat(regex).isEqualTo("a((aa|bb)(ab|ba)|(ab|ba)(aa|bb))b")
    }

    @Test
    fun `should build regex for rule 0 with repetition pattern`() {
        val rules = Rules(
            listOf(
                Rule.SubRules(0, listOf(listOf(4, 1, 4))),
                Rule.SubRules(1, listOf(listOf(5, 4), listOf(5, 4, 1))),
                Rule.SingleCharacter(4, 'a'),
                Rule.SingleCharacter(5, 'b')
            )
        )

        val regex = rules.buildRegexForRule(0)

        assertThat(regex).isEqualTo("a(ba)+a")
    }

    @Test
    fun `should build regex for rule 0 with inner repetition pattern`() {
        val rules = Rules(
            listOf(
                Rule.SubRules(0, listOf(listOf(4, 1, 4))),
                Rule.SubRules(1, listOf(listOf(5, 4, 4, 5), listOf(5, 4, 1, 4, 5))),
                Rule.SingleCharacter(4, 'a'),
                Rule.SingleCharacter(5, 'b')
            )
        )

        val regex = rules.buildRegexForRule(0)

        assertThat(regex).isEqualTo("aba(ba(ba(ba(ba(ba(baab)?ab)?ab)?ab)?ab)?ab)?aba")
    }

}
