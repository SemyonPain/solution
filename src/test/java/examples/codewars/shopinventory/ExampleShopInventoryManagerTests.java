package examples.codewars.shopinventory;

import examples.codewars.shopinventory.data.Item;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class ExampleShopInventoryManagerTests {

    private static final String TESTING = "Testing: ";
    private static final String MESSAGE = "Expected different value";

    private Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", -1, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Conjured Mana Cake", 3, 6),
            new Item("Yet another conjured mana cake", -1, 9)
    };

    @Test
    public void testEmptyCases() {
        Item[] items = null;
        ShopInventoryManager sim = new ShopInventoryManager(items);
        sim.dailyUpdate();
        assertNull(items);

        items = new Item[]{};
        sim = new ShopInventoryManager(items);
        sim.dailyUpdate();
        assertTrue(items.length == 0);
    }

    @Test
    public void testBasicCases() {
        ShopInventoryManager sim = new ShopInventoryManager(items);
        sim.dailyUpdate();

        // common case: both quality and sell_in are decreased by 1
        System.out.println(TESTING + items[0].getName());
        assertEquals(MESSAGE, 9, items[0].getSellIn());
        assertEquals(MESSAGE, 19, items[0].getQuality());

        // "Aged Brie" case: sell_in decreases, quality increases
        System.out.println(TESTING + items[1].getName());
        assertEquals(MESSAGE, 1, items[1].getSellIn());
        assertEquals(MESSAGE, 1, items[1].getQuality());

        // once the sell_in days is less then zero, quality degrades twice as fast
        System.out.println(TESTING + items[2].getName());
        assertEquals(MESSAGE, -2, items[2].getSellIn());
        assertEquals(MESSAGE, 5, items[2].getQuality());

        // "Sulfuras case": both quality and sell_in remains the same
        System.out.println(TESTING + items[3].getName());
        assertEquals(MESSAGE, 0, items[3].getSellIn());
        assertEquals(MESSAGE, 80, items[3].getQuality());

        // "Backstage in advance" case: while sell_in is 11 or more, quality increases by 1
        System.out.println(TESTING + items[4].getName());
        assertEquals(MESSAGE, 14, items[4].getSellIn());
        assertEquals(MESSAGE, 21, items[4].getQuality());

        // "Conjured" case: quality decreases by 2
        System.out.println(TESTING + items[5].getName());
        assertEquals(MESSAGE, 2, items[5].getSellIn());
        assertEquals(MESSAGE, 4, items[5].getQuality());

        // "Conjured" case + sell_in negative: quality decreases by 4
        System.out.println(TESTING + items[6].getName());
        assertEquals(MESSAGE, -2, items[6].getSellIn());
        assertEquals(MESSAGE, 5, items[6].getQuality());
    }

    @Test
    public void testBackstagePassCase() {
        String daysLeft = " when %d days left";
        Item[] items = new Item[]{new Item("yet another one backstage pass I don't know about", 11, 10)};
        ShopInventoryManager sim = new ShopInventoryManager(items);
        sim.dailyUpdate();

        // "Backstage in advance" case: while sell_in is 11 or more, quality increases by 1
        System.out.println(format(TESTING + items[0].getName() + daysLeft, items[0].getSellIn()));
        assertEquals(MESSAGE, 10, items[0].getSellIn());
        assertEquals(MESSAGE, 11, items[0].getQuality());

        sim.dailyUpdate();

        // "Backstage soon" case: while sell_in is (5;10] interval, quality increases by 2
        System.out.println(format(TESTING + items[0].getName() + daysLeft, items[0].getSellIn()));
        assertEquals(MESSAGE, 9, items[0].getSellIn());
        assertEquals(MESSAGE, 13, items[0].getQuality());

        for (int i = 9; i >= 5; i--)
            sim.dailyUpdate();

        // "Backstage directly" case: while sell_in is (0;5] interval, quality increases by 3
        System.out.println(format(TESTING + items[0].getName() + daysLeft, items[0].getSellIn()));
        assertEquals(MESSAGE, 4, items[0].getSellIn());
        assertEquals(MESSAGE, 24, items[0].getQuality());

        for (int i = 4; i >= 0; i--)
            sim.dailyUpdate();

        // "Backstage passed" case: while sell_in is 0 or lesser, quality drops to 0
        System.out.println(format(TESTING + items[0].getName() + daysLeft, items[0].getSellIn()));
        assertEquals(MESSAGE, -1, items[0].getSellIn());
        assertEquals(MESSAGE, 0, items[0].getQuality());
    }

    @Test
    public void testNearBordersCase() {
        Item[] items = new Item[]{
                new Item("some conjured potion", -2, 3),
                new Item("last ticket to backstage pass concert", 1, 48)
        };
        ShopInventoryManager sim = new ShopInventoryManager(items);
        sim.dailyUpdate();

        // "Conjured" case + sell_in negative: quality decreases by 4, but not below 0
        System.out.println(TESTING + items[0].getName());
        assertEquals(MESSAGE, -3, items[0].getSellIn());
        assertEquals(MESSAGE, 0, items[0].getQuality());

        // "Backstage directly" case: quality increases by 3, but not higher 50
        System.out.println(TESTING + items[1].getName());
        assertEquals(MESSAGE, 0, items[1].getSellIn());
        assertEquals(MESSAGE, 50, items[1].getQuality());
    }
}