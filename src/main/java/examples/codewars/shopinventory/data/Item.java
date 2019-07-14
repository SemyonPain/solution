package examples.codewars.shopinventory.data;

import examples.codewars.shopinventory.ShopInventoryManager;

/**
 * basic data class
 *
 * @see ShopInventoryManager
 * <p>
 * you should NOT edit the item constructor/class: it belong to the goblin in the corner who will insta-rage and
 * one-shot you as he doesn't believe in shared code ownership
 */
public class Item {

    private String name;
    private int sellIn;
    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
