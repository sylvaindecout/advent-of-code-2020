package fr.xebia.sdecout.advent.day25

data class Device(val publicKey: Long) {

    val loopSize by lazy { resolveLoopSize() }

    private fun resolveLoopSize(): Int {
        var loopSize = 0
        var value = 1L
        while (value != publicKey) {
            value = (value * 7) % 20_201_227
            loopSize += 1
        }
        return loopSize
    }

    fun transformSubjectNumber(subjectNumber: Long) = transformSubjectNumber(subjectNumber, loopSize)

    private fun transformSubjectNumber(subjectNumber: Long, loopSize: Int) = (1..loopSize)
        .fold(1L) { value, _ -> (value * subjectNumber) % 20_201_227 }

}
