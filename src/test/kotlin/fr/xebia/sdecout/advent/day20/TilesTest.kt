package fr.xebia.sdecout.advent.day20

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.nio.file.Files.readString
import java.nio.file.Paths

class TilesTest {

    @Test
    @Tag("Integration")
    fun `should find corners`() {
        val input = Paths.get("src/main/resources/day20/example.txt")

        val cornerTileIds = Tiles(input).getCornerTileIds()

        assertThat(cornerTileIds).containsExactlyInAnyOrder(
            1951, 3079,
            2971, 1171
        )
    }

    @Test
    @Tag("Integration")
    fun `should reassemble tiles`() {
        val input = Paths.get("src/main/resources/day20/example.txt")
        val expected = readString(Paths.get("src/test/resources/day20/exemple-assembled.txt"))

        val image = Tiles(input).reassemble()

        assertThat(image.data.possibleVariants.map{it.toString()}).contains(expected)
    }

}
