package fr.xebia.sdecout.advent.day25

fun main() {

    val comboBreaker = ComboBreaker(
        card = Device(12_320_657),
        door = Device(9_659_666)
    )

    val encryptionKey = comboBreaker.encryptionKey

    println("Answer: $encryptionKey")

}
