package fr.xebia.sdecout.advent.day5

import org.assertj.core.api.SoftAssertions.assertSoftly
import org.junit.jupiter.api.Test

class SeatPositionTest {

    @Test
    fun `should resolve from code`() {
        assertSoftly {
            it.assertThat(SeatPosition.fromCode("BFFFBBFRRR")).isEqualTo(SeatPosition(70, 7))
            it.assertThat(SeatPosition.fromCode("FFFBBBFRRR")).isEqualTo(SeatPosition(14, 7))
            it.assertThat(SeatPosition.fromCode("BBFFBBFRLL")).isEqualTo(SeatPosition(102, 4))
        }
    }

    @Test
    fun `should get seat ID`() {
        assertSoftly {
            it.assertThat(SeatPosition(70, 7).getSeatId()).isEqualTo(567)
            it.assertThat(SeatPosition(14, 7).getSeatId()).isEqualTo(119)
            it.assertThat(SeatPosition(102, 4).getSeatId()).isEqualTo(820)
        }
    }

}
