package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if(isAgedBrie(i)){
                AgedBrie(items[i]).updateQuality()
            }
            if (!isAgedBrie(i) && !isBackstagePasses(i)) {
                decreaseQuality(i)
            } else {
                if (isBackstagePasses(i)) {
                    BackStagePasses(items[i]).updateQuality()
                }
            }

            decreaseSellIn(i)

            if (items[i].sellIn < 0) {
                if (!isAgedBrie(i)) {
                    if (isBackstagePasses(i)) {
                        items[i].quality = 0
                    } else {
                        decreaseQuality(i)
                    }
                } else {
                    increaseQuality(i)
                }
            }
        }
    }



    private fun decreaseQuality(i: Int) {
        if (items[i].quality > 0 && isNotSulfuras(i)) {
            items[i].quality = items[i].quality - 1
        }
    }

    private fun increaseQuality(i: Int) {
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1
        }
    }

    private fun decreaseSellIn(i: Int) {
        if (isNotSulfuras(i)) {
            items[i].sellIn = items[i].sellIn - 1
        }
    }

    private fun isBackstagePasses(i: Int) = items[i].name == "Backstage passes to a TAFKAL80ETC concert"
    private fun isNotSulfuras(i: Int) = items[i].name != "Sulfuras, Hand of Ragnaros"
    private fun isAgedBrie(i: Int) = items[i].name == "Aged Brie"

}

class AgedBrie(private val item: Item) {
    fun updateQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1
        }
    }
}

class BackStagePasses(val item:Item){
    fun updateQuality(){
        ++item.quality
        if (tenDaysOrLessForSellIn()) {
            ++item.quality
        }

        if (fiveDaysOrLessForSellIn()) {
            ++item.quality
        }

        if(item.sellIn < 0)
            item.quality = 0
    }

    private fun fiveDaysOrLessForSellIn() = item.sellIn < 6

    private fun tenDaysOrLessForSellIn() = item.sellIn < 11
}

class Sulfuras(val item:Item){
    fun updateQuality(){

    }

    fun updateSellIn(){

    }
}

