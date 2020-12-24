package fr.xebia.sdecout.advent.day24

enum class Direction {

    EAST {
        override fun from(tile: Hexagon) = Hexagon(tile.x + 1, tile.y + 1)
    },
    SOUTHEAST {
        override fun from(tile: Hexagon) = Hexagon(tile.x, tile.y + 1)
    },
    SOUTHWEST {
        override fun from(tile: Hexagon) = Hexagon(tile.x - 1, tile.y)
    },
    WEST {
        override fun from(tile: Hexagon) = Hexagon(tile.x - 1, tile.y - 1)
    },
    NORTHWEST {
        override fun from(tile: Hexagon) = Hexagon(tile.x, tile.y - 1)
    },
    NORTHEAST {
        override fun from(tile: Hexagon) = Hexagon(tile.x + 1, tile.y)
    };

    abstract fun from(tile: Hexagon): Hexagon

}
