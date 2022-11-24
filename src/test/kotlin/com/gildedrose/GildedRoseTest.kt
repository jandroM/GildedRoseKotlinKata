package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

const val AGED_BRIE = "Aged Brie"
const val ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose"

internal class GildedRoseTest {

    companion object {
        @JvmStatic
        fun generateCases(): Stream<Arguments> = Stream.of(
            Arguments.of(Item(AGED_BRIE, 2, 0), 1, 1),
            Arguments.of(Item(ELIXIR_OF_THE_MONGOOSE, 5, 7), 4, 6),
            Arguments.of(Item(ELIXIR_OF_THE_MONGOOSE, 0, 7), -1, 5),
            Arguments.of(Item(ELIXIR_OF_THE_MONGOOSE, 3, 0), 2, 0),
            Arguments.of(Item(AGED_BRIE, 3, 50), 2, 50)
        )
    }

    @ParameterizedTest
    @MethodSource("generateCases")
    fun test(item: Item, expectedSellIn: Int, expectedQuality: Int) {
        val app = GildedRose(listOf(item))
        app.updateQuality()
        assertEquals(expectedSellIn, item.sellIn)
        assertEquals(expectedQuality, item.quality)
    }
}


