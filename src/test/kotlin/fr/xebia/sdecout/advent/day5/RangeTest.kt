package fr.xebia.sdecout.advent.day5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RangeTest {

    @Test
    fun `should get upper half`() {
        assertThat(Range(32, 47).getUpperHalf()).isEqualTo(Range(40, 47))
    }

    @Test
    fun `should get lower half`() {
        assertThat(Range(44, 47).getLowerHalf()).isEqualTo(Range(44, 45))
    }

    @Test
    fun `should get value if range is only one`() {
        assertThat(Range(44, 44).getValue()).isEqualTo(44)
    }

}
