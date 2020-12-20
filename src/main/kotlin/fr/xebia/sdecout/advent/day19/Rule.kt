package fr.xebia.sdecout.advent.day19

sealed class Rule(open val id: Int) {

    companion object {
        fun parse(line: String) = line.split(": ", limit = 2).let {
            val id = it[0].toInt()
            val value = it[1]
            if (value.startsWith('"')) SingleCharacter(id, value[1])
            else SubRules(id, value.split(" | ").map { sequence ->
                sequence.split(" ").map { id -> id.toInt() }
            })
        }
    }

    data class SingleCharacter(
        override val id: Int,
        val character: Char
    ) : Rule(id)

    data class SubRules(
        override val id: Int,
        val rules: List<List<Int>>
    ) : Rule(id){
        fun hasRecursivePattern() = rules.size == 2 && id in rules[1]
    }

}
