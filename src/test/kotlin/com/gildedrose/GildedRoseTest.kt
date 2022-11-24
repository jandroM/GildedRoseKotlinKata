package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class GildedRoseTest {

    @Test
    fun foo() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)
    }

    @Test
    fun reduces_quality_every_day(){
        val items = listOf(Item("foo", 1, 1))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun quality_is_never_negative(){
        val items = listOf(Item("foo", 1, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun reduces_sellin_every_day(){
        val items = listOf(Item("foo", 1, 1))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].sellIn)
    }

    @Test
    fun quality_decreases_twice_as_fast_after_sellin(){
        val items = listOf(Item("foo", 0, 2))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun aged_brie_quality_increases(){
        val items = listOf(Item("Aged Brie", 1, 1))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(2, app.items[0].quality)
    }

    @Test
    fun any_item_has_max_quality_of_fifty(){
        val items = listOf(Item("Aged Brie", 1, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun backstage_passes_increase_quality_twice_as_sellin_approaches(){
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 7, 2))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, app.items[0].quality)
    }

    @Test
    fun backstage_passes_increase_quality_thrice_as_sellin_approaches(){
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 4, 2))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(5, app.items[0].quality)
    }

    @Test
    fun backstage_passes_is_zero_after_concert(){
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 2))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }
    @Test
    fun sulfuras_has_not_to_be_sold(){
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 2, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(80, app.items[0].quality)
        assertEquals(2, app.items[0].sellIn)
    }

    @Test
    fun conjured_mana(){
        val items = listOf(Item( "Conjured Mana Cake", 2, 2))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }
}


