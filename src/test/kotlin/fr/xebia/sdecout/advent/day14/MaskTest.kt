package fr.xebia.sdecout.advent.day14

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MaskTest {

    @Test
    fun `should apply mask with change`() {
        val mask = Mask("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X")
        assertThat(mask.applyTo(11)).isEqualTo(73)
    }

    @Test
    fun `should apply mask with no change`() {
        val mask = Mask("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X")
        assertThat(mask.applyTo(101)).isEqualTo(101)
    }

    @Test
    fun `should apply mask with all change`() {
        val mask = Mask("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X")
        assertThat(mask.applyTo(0)).isEqualTo(64)
    }

    @Test
    fun `should resolve possible values for example #1`() {
        val mask = Mask("000000000000000000000000000000X1001X")
        assertThat(mask.resolvePossibleValuesFor(42)).containsExactlyInAnyOrder(
            26, 27, 58, 59
        )
    }

    @Test
    fun `should resolve possible values for example #2`() {
        val mask = Mask("00000000000000000000000000000000X0XX")
        assertThat(mask.resolvePossibleValuesFor(26)).containsExactlyInAnyOrder(
            16, 17, 18, 19, 24, 25, 26, 27
        )
    }

}

