package examples.codewars.shopinventory.data;

import examples.codewars.shopinventory.ShopInventoryManager;

import java.util.function.BiPredicate;

import static examples.codewars.shopinventory.data.ItemWrapper.ItemType.*;
import static examples.codewars.shopinventory.data.ItemWrapper.PeriodType.*;
import static java.util.Arrays.stream;

/**
 * wrapping for data class where we calculate item's property to apply on it correct business logic
 *
 * @see ShopInventoryManager
 * @see Item
 */
public class ItemWrapper {

    private final static int PASSED_LIMIT = 0;
    private final static int DIRECTLY_LIMIT = 6;
    private final static int SOON_LIMIT = 11;

    private final static BiPredicate<String, String> CONTAINS_IGNORE_CASE = (name, type) -> name.toLowerCase()
            .contains(type.toLowerCase());

    private Item item;
    private ItemType itemType;

    public ItemWrapper(Item item) {
        this.item = item;
        itemType = stream(new ItemType[]{AGED_BRIE,
                SULPHURAS,
                BACKSTAGE_PASS,
                CONJURED}).filter(
                type -> CONTAINS_IGNORE_CASE.test(item.getName(), type.typeName))
                .findFirst()
                .orElse(DEFAULT);
    }

    public String getName() {
        return item.getName();
    }

    public void setName(String name) {
        item.setName(name);
    }

    public int getQuality() {
        return item.getQuality();
    }

    public void setQuality(int quality) {
        item.setQuality(quality);
    }

    public int getSellIn() {
        return item.getSellIn();
    }

    public void setSellIn(int sellIn) {
        item.setSellIn(sellIn);
    }

    public ItemType getItemType() {
        return itemType;
    }

    public PeriodType getPeriodType() {
        int sellIn = getSellIn();
        return sellIn <= PASSED_LIMIT ? PASSED : sellIn < DIRECTLY_LIMIT ? DIRECTLY : sellIn < SOON_LIMIT ? SOON : IN_ADVANCE;
    }

    public enum ItemType {
        AGED_BRIE("Aged Brie"), SULPHURAS("Sulfuras"), BACKSTAGE_PASS("Backstage pass"), CONJURED("Conjured"), DEFAULT(
                "Default");

        private String typeName;

        ItemType(String typeName) {
            this.typeName = typeName;
        }
    }

    public enum PeriodType {IN_ADVANCE, SOON, DIRECTLY, PASSED}
}
