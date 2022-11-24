package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

const val AGED_BRIE = "Aged Brie"

internal class GildedRoseTest {

    @Test
    fun `aged brie should increase in quality`() {
        val items = listOf(Item(AGED_BRIE, 2, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, items[0].quality)
        assertEquals(1, items[0].sellIn)
    }
}


