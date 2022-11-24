package com.gildedrose

private const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
private const val LEGENDARY_ITEM = "Sulfuras, Hand of Ragnaros"
private const val AGED_BRIE = "Aged Brie"

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (item.name != AGED_BRIE && item.name != BACKSTAGE_PASSES) {
                if (item.quality > 0) {
                    if (checkIfNotLegendary(item)) {
                        decreaseQuality(item)
                    }
                }
            } else {
                if (item.quality < 50) {
                    increaseQuality(item)

                    if (item.name == BACKSTAGE_PASSES) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                increaseQuality(item)
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                increaseQuality(item)
                            }
                        }
                    }
                }
            }

            if (checkIfNotLegendary(item)) {
                item.sellIn = item.sellIn - 1
            }

            if (item.sellIn < 0) {
                if (item.name != AGED_BRIE) {
                    if (item.name == BACKSTAGE_PASSES) {
                        item.quality = 0
                    } else {
                        if (item.quality > 0) {
                            if (checkIfNotLegendary(item)) {
                                decreaseQuality(item)
                            }
                        }
                    }
                } else {
                    if (item.quality < 50) {
                        increaseQuality(item)
                    }
                }
            }
        }
    }

    private fun checkIfNotLegendary(item: Item) = item.name != LEGENDARY_ITEM

    private fun increaseQuality(item: Item) {
        item.quality = item.quality + 1
    }

    private fun decreaseQuality(item: Item) {
        item.quality = item.quality - 1
    }

}

