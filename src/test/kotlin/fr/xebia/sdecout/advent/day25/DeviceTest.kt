package fr.xebia.sdecout.advent.day25

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DeviceTest {

    @Test
    fun `should resolve loop size for the card's public key`() {
        val card = Device(publicKey = 5_764_801)

        val loopSize = card.loopSize

        assertThat(loopSize).isEqualTo(8)
    }

    @Test
    fun `should resolve loop size for the door's public key`() {
        val door = Device(publicKey = 17_807_724)

        val loopSize = door.loopSize

        assertThat(loopSize).isEqualTo(11)
    }

}
