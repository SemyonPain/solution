package examples.codewars.shopinventory;

import examples.codewars.shopinventory.data.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleShopInventoryManagerTests {

    private static final String TESTING = "Testing: ";
    private static final String MESSAGE = "Expected different value";

    private Item[] items = new Item[]{new Item("+5 Dexterity Vest", 10, 20), new Item("Aged Brie", 2, 0), new Item(
            "Elixir of the Mongoose", 5, 7), new Item("Sulfuras, Hand of Ragnaros", 0, 80), new Item(
            "Backstage passes to a TAFKAL80ETC concert", 15, 20), new Item("Conjured Mana Cake", 3, 6)};

    @Test
    public void testBasicCases() {
        ShopInventoryManager sim = new ShopInventoryManager(items);
        sim.updateQuality();

        System.out.println(TESTING + items[0].getName());
        assertEquals(MESSAGE, 9, items[0].getSellIn());
        assertEquals(MESSAGE, 19, items[0].getQuality());

        System.out.println(TESTING + items[1].getName());
        assertEquals(MESSAGE, 1, items[1].getSellIn());
        assertEquals(MESSAGE, 1, items[1].getQuality());

        System.out.println(TESTING + items[2].getName());
        assertEquals(MESSAGE, 4, items[2].getSellIn());
        assertEquals(MESSAGE, 6, items[2].getQuality());

        System.out.println(TESTING + items[3].getName());
        assertEquals(MESSAGE, 0, items[3].getSellIn());
        assertEquals(MESSAGE, 80, items[3].getQuality());

        System.out.println(TESTING + items[4].getName());
        assertEquals(MESSAGE, 14, items[4].getSellIn());
        assertEquals(MESSAGE, 21, items[4].getQuality());

        System.out.println(TESTING + items[5].getName());
        assertEquals(MESSAGE, 2, items[5].getSellIn());
        assertEquals(MESSAGE, 4, items[5].getQuality());
    }
}