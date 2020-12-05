package fr.xebia.sdecout.advent.day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PassportFieldTest {

    @Test
    fun `should validate Birth Year for valid value`() {
        assertThat(PassportField.byr.isValid("1923")).isTrue
    }

    @Test
    fun `should not validate Birth Year for value below 1900`() {
        assertThat(PassportField.byr.isValid("1899")).isFalse
    }

    @Test
    fun `should not validate Birth Year for value including alpha chars`() {
        assertThat(PassportField.byr.isValid("abcd")).isFalse
    }

    @Test
    fun `should not validate Hair Color for value with not enough chars`() {
        assertThat(PassportField.hcl.isValid("#11111")).isFalse
    }

    @Test
    fun `should not validate Hair Color for value with too many chars`() {
        assertThat(PassportField.hcl.isValid("#1111111")).isFalse
    }

    @ParameterizedTest
    @ValueSource(strings = ["#111111", "#b11f11"])
    fun `should not validate Hair Color for value with valid value`(value: String) {
        assertThat(PassportField.hcl.isValid(value)).isTrue
    }

    @ParameterizedTest
    @ValueSource(strings = ["b11f11", "bb11f11"])
    fun `should not validate Hair Color for value with missing #`(value: String) {
        assertThat(PassportField.hcl.isValid(value)).isFalse
    }

    @Test
    fun `should not validate Hair Color for value with invalid chars`() {
        assertThat(PassportField.hcl.isValid("#xxxxxx")).isFalse
    }

    @ParameterizedTest
    @ValueSource(strings = ["amb", "blu", "brn", "gry", "grn", "hzl", "oth"])
    fun `should validate Eye Color for valid value`(value: String) {
        assertThat(PassportField.ecl.isValid(value)).isTrue
    }

    @Test
    fun `should not validate Eye Color for unknown value`() {
        assertThat(PassportField.ecl.isValid("xxx")).isFalse
    }

    @Test
    fun `should validate Passport ID for valid value`() {
        assertThat(PassportField.pid.isValid("111111111")).isTrue
    }

    @Test
    fun `should validate Passport ID for not enough digits`() {
        assertThat(PassportField.pid.isValid("11111111")).isFalse
    }

    @Test
    fun `should validate Passport ID for too many digits`() {
        assertThat(PassportField.pid.isValid("1111111111")).isFalse
    }

    @Test
    fun `should not validate Height for value below 150 centimeters`() {
        assertThat(PassportField.hgt.isValid("149cm")).isFalse
    }

    @ParameterizedTest
    @ValueSource(strings = ["150cm", "193cm"])
    fun `should validate Height for valid value in centimeters`(value: String) {
        assertThat(PassportField.hgt.isValid(value)).isTrue
    }

    @Test
    fun `should not validate Height for value above 193 centimeters`() {
        assertThat(PassportField.hgt.isValid("194cm")).isFalse
    }

    @Test
    fun `should not validate Height for value below 59 inches`() {
        assertThat(PassportField.hgt.isValid("58in")).isFalse
    }

    @ParameterizedTest
    @ValueSource(strings = ["59in", "76in"])
    fun `should validate Height for valid value in inches`(value: String) {
        assertThat(PassportField.hgt.isValid(value)).isTrue
    }

    @Test
    fun `should not validate Height for value above 76 inches`() {
        assertThat(PassportField.hgt.isValid("77in")).isFalse
    }

    @Test
    fun `should not validate Height for value in unknown unit`() {
        assertThat(PassportField.hgt.isValid("nawak")).isFalse
    }

}
