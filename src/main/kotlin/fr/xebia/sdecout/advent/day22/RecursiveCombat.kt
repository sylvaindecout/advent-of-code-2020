package fr.xebia.sdecout.advent.day22

import java.nio.file.Files.readString
import java.nio.file.Path

class RecursiveCombat(inputFile: Path) {

    private val decks: Map<Player, Deck> = readString(inputFile).dropLast(1).split("\n\n")
        .let { splitString -> splitString.indices.map { Player(it + 1) to splitString[it].toDeck() }.toMap() }

    private fun String.toDeck() = Deck(this.split("\n").drop(1).map { Card(it.toInt()) })

    fun play() = Game(decks).play()

}
