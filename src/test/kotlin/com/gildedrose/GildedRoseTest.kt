package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

const val AGED_BRIE = "Aged Brie"
const val SULFURAS = "Sulfuras, Hand of Ragnaros"
const val ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose"

internal class GildedRoseTest {

    companion object {
        @JvmStatic
        fun generateCases(): Stream<Arguments> = Stream.of(
            Arguments.of("“Aged Brie” actually increases in Quality the older it gets", Item(AGED_BRIE, 2, 0), 1, 1),
            Arguments.of("Normal item decreases quality by 1", Item(ELIXIR_OF_THE_MONGOOSE, 5, 7), 4, 6),
            Arguments.of(
                "Once the sell by date has passed, Quality degrades twice as fast",
                Item(ELIXIR_OF_THE_MONGOOSE, 0, 7),
                -1,
                5
            ),
            Arguments.of("The Quality of an item is never negative", Item(ELIXIR_OF_THE_MONGOOSE, 3, 0), 2, 0),
            Arguments.of("The Quality of an item is never more than 50", Item(AGED_BRIE, 3, 50), 2, 50),
            Arguments.of("Sulfuras legendary item it's unalterable", Item(SULFURAS, 3, 50), 3, 50),
        )
    }

    @ParameterizedTest
    @MethodSource("generateCases")
    fun test(case: String, item: Item, expectedSellIn: Int, expectedQuality: Int) {
        val app = GildedRose(listOf(item))
        app.updateQuality()
        assertEquals(expectedSellIn, item.sellIn, "$case expectedSellIn")
        assertEquals(expectedQuality, item.quality, "$case expectedQuality")
    }
}


