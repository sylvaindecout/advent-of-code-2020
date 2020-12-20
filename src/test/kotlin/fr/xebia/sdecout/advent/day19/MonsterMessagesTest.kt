package fr.xebia.sdecout.advent.day19

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class MonsterMessagesTest {

    @Test
    @Tag("Integration")
    fun `should determine the number of messages that completely match rule 0`() {
        val input = Paths.get("src/main/resources/day19/example.txt")
        val monsterMessages = MonsterMessages.parse(input)

        val validMessages = monsterMessages.validMessages

        assertThat(validMessages)
            .hasSize(2)
            .containsExactly(
                "ababbb",
                "abbbab"
            )
    }

    @Test
    @Tag("Integration")
    fun `should determine the number of messages that completely match rule 0 with no loops`() {
        val input = Paths.get("src/main/resources/day19/example-2.txt")
        val monsterMessages = MonsterMessages.parse(input)

        val validMessages = monsterMessages.validMessages

        assertThat(validMessages)
            .hasSize(3)
            .containsExactly(
                "bbabbbbaabaabba",
                "ababaaaaaabaaab",
                "ababaaaaabbbaba"
            )
    }

    @Test
    @Tag("Integration")
    fun `should determine the number of messages that completely match rule 0 with loops`() {
        val input = Paths.get("src/main/resources/day19/example-2.txt")
        val monsterMessages = MonsterMessages.parse(input).fix()

        val validMessages = monsterMessages.validMessages

        assertThat(validMessages)
            .hasSize(12)
            .containsExactly(
                "bbabbbbaabaabba",
                "babbbbaabbbbbabbbbbbaabaaabaaa",
                "aaabbbbbbaaaabaababaabababbabaaabbababababaaa",
                "bbbbbbbaaaabbbbaaabbabaaa",
                "bbbababbbbaaaaaaaabbababaaababaabab",
                "ababaaaaaabaaab",
                "ababaaaaabbbaba",
                "baabbaaaabbaaaababbaababb",
                "abbbbabbbbaaaababbbbbbaaaababb",
                "aaaaabbaabaaaaababaa",
                "aaaabbaabbaaaaaaabbbabbbaaabbaabaaa",
                "aabbbbbaabbbaaaaaabbbbbababaaaaabbaaabba"
            )
    }

    @Test
    fun `should filter messages that completely match rule 0`() {
        val monsterMessages = MonsterMessages(
            rules = Rules(
                listOf(
                    Rule.SubRules(0, listOf(listOf(4, 1, 5))),
                    Rule.SubRules(1, listOf(listOf(2, 3), listOf(3, 2))),
                    Rule.SubRules(2, listOf(listOf(4, 4), listOf(5, 5))),
                    Rule.SubRules(3, listOf(listOf(4, 5), listOf(5, 4))),
                    Rule.SingleCharacter(4, 'a'),
                    Rule.SingleCharacter(5, 'b')
                )
            ),
            messages = listOf(
                "ababbb",
                "bababa",
                "abbbab",
                "aaabbb",
                "aaaabbb"
            )
        )

        val validMessages = monsterMessages.validMessages

        assertThat(validMessages).containsExactly(
            "ababbb",
            "abbbab",
        )
    }

}
