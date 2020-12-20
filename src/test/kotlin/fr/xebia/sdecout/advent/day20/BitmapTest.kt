package fr.xebia.sdecout.advent.day20

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BitmapTest {

    @Test
    fun `should rotate clockwise`() {
        val bitmap = Bitmap(arrayOf(
            booleanArrayOf(true, true, false),
            booleanArrayOf(false, true, false),
            booleanArrayOf(false, false, true)
        ))
        assertThat(bitmap.rotateClockwise()).isEqualTo(Bitmap(arrayOf(
            booleanArrayOf(false, false, true),
            booleanArrayOf(false, true, true),
            booleanArrayOf(true, false, false)
        )))
    }

    @Test
    fun `should go back to initial state after 4 rotations`() {
        val bitmap = Bitmap(arrayOf(
            booleanArrayOf(true, true, false),
            booleanArrayOf(false, true, false),
            booleanArrayOf(false, false, true)
        ))
        assertThat(bitmap.rotateClockwise(times = 4)).isEqualTo(bitmap)
    }

    @Test
    fun `should resolve top edge`(){
        val bitmap = Bitmap(arrayOf(
            booleanArrayOf(true, true, false),
            booleanArrayOf(false, true, false),
            booleanArrayOf(false, false, true)
        ))
        assertThat(bitmap.topEdge.content).containsExactly(true, true, false)
    }

    @Test
    fun `should resolve left edge`(){
        val bitmap = Bitmap(arrayOf(
            booleanArrayOf(true, true, false),
            booleanArrayOf(false, true, false),
            booleanArrayOf(false, false, true)
        ))
        assertThat(bitmap.leftEdge.content).containsExactly(true, false, false)
    }

    @Test
    fun `should resolve bottom edge`(){
        val bitmap = Bitmap(arrayOf(
            booleanArrayOf(true, true, false),
            booleanArrayOf(false, true, false),
            booleanArrayOf(false, false, true)
        ))
        assertThat(bitmap.bottomEdge.content).containsExactly(false, false, true)
    }

    @Test
    fun `should resolve right edge`(){
        val bitmap = Bitmap(arrayOf(
            booleanArrayOf(true, true, false),
            booleanArrayOf(false, true, false),
            booleanArrayOf(false, false, true)
        ))
        assertThat(bitmap.rightEdge.content).containsExactly(false, false, true)
    }

}
