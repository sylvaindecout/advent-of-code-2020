package fr.xebia.sdecout.advent.day13

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions.assertSoftly
import org.junit.jupiter.api.Test

class BusTest {

    @Test
    fun `should resolve next departure time`() {
        val bus = Bus.Active(59)
        assertThat(bus.nextDepartureTime(939)).isEqualTo(944)
    }

    @Test
    fun `should tell if bus depart at selected time`() {
        assertSoftly {
            it.assertThat(Bus.Active(7).departsAt(1068781)).isTrue
            it.assertThat(Bus.Active(13).departsAt(1068781 + 1)).isTrue
            it.assertThat(Bus.Active(59).departsAt(1068781 + 4)).isTrue
            it.assertThat(Bus.Active(31).departsAt(1068781 + 6)).isTrue
            it.assertThat(Bus.Active(19).departsAt(1068781 + 7)).isTrue
        }
    }

}
