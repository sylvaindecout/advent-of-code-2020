package fr.xebia.sdecout.advent.day21

import java.nio.file.Paths

fun main() {

    val input = Paths.get("src/main/resources/day21/puzzle-input.txt")

    val allergenAssessment = AllergenAssessment(input)

    val nbSafeIngredients = allergenAssessment.countOccurrencesOfSafeIngredients()
    println("Answer (part 1): $nbSafeIngredients")

    val canonicalDangerousIngredientList = allergenAssessment.generateCanonicalDangerousIngredientList()
    println("Answer (part 2): $canonicalDangerousIngredientList")

}
