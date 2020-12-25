package fr.xebia.sdecout.advent.day25

data class ComboBreaker(
    val card: Device,
    val door: Device
) {
    val encryptionKey by lazy { card.transformSubjectNumber(door.publicKey) }
}
