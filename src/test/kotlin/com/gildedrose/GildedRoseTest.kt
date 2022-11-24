package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

const val AGED_BRIE = "Aged Brie"
const val ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose"

internal class GildedRoseTest {

    @Test
    fun `aged brie should increase in quality`() {
        val items = listOf(Item(AGED_BRIE, 2, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, items[0].quality)
        assertEquals(1, items[0].sellIn)
    }

    @Test
    fun `elixir of the mongoose should decrease in quality and sellIn`() {
        val items = listOf(Item(ELIXIR_OF_THE_MONGOOSE, 5, 7))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(6, items[0].quality)
        assertEquals(4, items[0].sellIn)
    }
}


