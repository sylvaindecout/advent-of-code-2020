package fr.xebia.sdecout.advent.day19

data class Rules(val rules: Collection<Rule>) {

    fun fix() = Rules(rules.map {
        when (it) {
            Rule.SubRules(8, listOf(listOf(42))) -> Rule.SubRules(8, listOf(listOf(42), listOf(42, 8)))
            Rule.SubRules(11, listOf(listOf(42, 31))) -> Rule.SubRules(11, listOf(listOf(42, 31), listOf(42, 11, 31)))
            else -> it
        }
    })

    fun validates(message: String): Boolean {
        return Regex(buildRegexForRule(0)).matches(message)
    }

    fun buildRegexForRule(id: Int, depth: Int = 0): String {
        val rule: Rule = rules.find { it.id == id }
            ?: throw IllegalStateException("No rule with ID $id")
        return when (rule) {
            is Rule.SingleCharacter -> rule.character.toString()
            is Rule.SubRules -> buildRegexForSubRules(rule, depth)
        }
    }

    private fun buildRegexForSubRules(rule: Rule.SubRules, depth: Int) = when {
        rule.rules.size == 1 -> createRegexForRules(rule.rules[0])
        rule.hasRecursivePattern() -> rule.rules[1].let { sequenceWithRecursion ->
            when (val indexOfSelf = sequenceWithRecursion.indexOf(rule.id)) {
                0 -> createRegexForRules(sequenceWithRecursion.subList(indexOfSelf + 1, sequenceWithRecursion.size))
                    .let { "($it)+" }
                sequenceWithRecursion.size - 1 -> createRegexForRules(sequenceWithRecursion.subList(0, indexOfSelf))
                    .let { "($it)+" }
                else -> createRegexForRules(sequenceWithRecursion.subList(0, indexOfSelf)) +
                        createRegexForRecursiveRule(rule.id, depth) +
                        createRegexForRules(sequenceWithRecursion.subList(indexOfSelf + 1, sequenceWithRecursion.size))
            }
        }
        else -> rule.rules.joinToString(separator = "|") { createRegexForRules(it) }.let { "($it)" }
    }

    /**
     * Since it is not possible to define recursive regex patterns in Kotlin,
     * we do it manually and define a max depth to avoid infinite recursion.
     */
    private fun createRegexForRecursiveRule(ruleId: Int, depth: Int) = if (depth > 5) ""
    else buildRegexForRule(ruleId, depth + 1).let { "($it)?" }

    private fun createRegexForRules(ruleIds: List<Int>) =
        ruleIds.fold("") { regex, ruleId -> regex + buildRegexForRule(ruleId) }

    companion object {
        fun parse(lines: List<String>) = Rules(lines.map { Rule.parse(it) })
    }

}
