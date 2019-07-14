package examples.codewars.shopinventory;

import examples.codewars.shopinventory.data.Item;
import examples.codewars.shopinventory.data.ItemWrapper;

import static examples.codewars.shopinventory.functional.IUpdateItem.UPDATER;
import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;

/**
 * @see <a href="shop-inventory-manager">https://www.codewars.com/kata/shop-inventory-manager/train/java</a>
 */
public class ShopInventoryManager {

    private Item[] items;

    public ShopInventoryManager(Item[] items) {
        this.items = items;
    }

    public void dailyUpdate() {
        stream(ofNullable(items).orElse(new Item[]{})).forEach(item -> UPDATER.update(new ItemWrapper(item)));
    }
}
