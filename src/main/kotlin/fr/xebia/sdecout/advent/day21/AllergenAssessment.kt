package fr.xebia.sdecout.advent.day21

import java.nio.file.Files.readAllLines
import java.nio.file.Path

class AllergenAssessment(inputFile: Path) {

    private val foods: List<Food> = readAllLines(inputFile).map { it.toFood() }

    private val ingredients by lazy { foods.flatMap { it.ingredients }.distinct() }
    private val allergens by lazy { foods.flatMap { it.allergens }.distinct() }

    fun generateCanonicalDangerousIngredientList() = assessAllergenRepartition().toList()
        .sortedBy { it.first.name }
        .map { it.second }
        .joinToString(",") { it.name }

    fun countOccurrencesOfSafeIngredients() = singleOutSafeIngredients().sumBy { countOccurrencesOf(it) }

    private fun countOccurrencesOf(ingredient: Ingredient) = foods.count { ingredient in it.ingredients }

    private fun singleOutSafeIngredients() = assessAllergenRepartition().let { allergenRepartition ->
        ingredients.filter { ingredient -> ingredient !in allergenRepartition.values }
    }

    private fun <T> intersect(lists: List<List<T>>) = lists.fold(lists.flatten()) { all, list ->
        all.intersect(list).toList()
    }

    private fun assessAllergenRepartition() = allergens
        .map { allergen -> allergen to foods.filter { food -> allergen in food.allergens } }
        .map { allergenAndFoods -> allergenAndFoods.first to intersect(allergenAndFoods.second.map { food -> food.ingredients }) }
        .toMap()
        .let { refine(it) }

    private fun refine(allergenRepartition: Map<Allergen, List<Ingredient>>): Map<Allergen, Ingredient> =
        allergenRepartition
            .filter { it.value.size == 1 }
            .map { it.value.first() }
            .fold(allergenRepartition) { former, ingredient -> former.remove(ingredient) }
            .let { if (it == allergenRepartition) it.toSingleIngredientMapping() else refine(it) }

    private fun Map<Allergen, List<Ingredient>>.remove(ingredient: Ingredient) = this.toList().map {
        it.first to if (it.second.size > 1 && ingredient in it.second) it.second - ingredient else it.second
    }.toMap()

    private fun Map<Allergen, List<Ingredient>>.toSingleIngredientMapping() =
        this.toList().map { it.first to it.second.first() }.toMap()

    private fun String.toFood() = this.split(" (contains ", limit = 2).let { splitString ->
        Food(
            ingredients = splitString[0].split(" ").map { Ingredient(it) },
            allergens = splitString[1].replace(")", "").split(", ").map { Allergen(it) }
        )
    }

}
