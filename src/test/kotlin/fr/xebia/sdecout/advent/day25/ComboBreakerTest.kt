package fr.xebia.sdecout.advent.day25

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ComboBreakerTest {

    @Test
    fun `should resolve the encryption key`() {
        val comboBreaker = ComboBreaker(
            card = Device(publicKey = 5_764_801),
            door = Device(publicKey = 17_807_724)
        )

        val encryptionKey = comboBreaker.encryptionKey

        assertThat(encryptionKey).isEqualTo(14_897_079)
    }

}
