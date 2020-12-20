package fr.xebia.sdecout.advent.day20

import java.nio.file.Paths

fun main() {

    val input = Paths.get("src/main/resources/day20/puzzle-input.txt")

    val tiles = Tiles(input)
    val answer1 = tiles.getCornerTileIds()
        .fold(1L) { product, id -> product * id }
    println("Answer (part 1): $answer1")

    val monster = listOf(
        "..................#.",
        "#....##....##....###",
        ".#..#..#..#..#..#...",
    ).toPattern()
    val image = tiles.reassemble()
    val answer2 = image.countHashesExcluding(monster)
    println("Answer (part 2): $answer2")

}

private fun List<String>.toPattern() = Array(this.size - 1) { y ->
    BooleanArray(this[1].length) { x -> this[y + 1][x] == '#' }
}.let { Pattern(it) }
