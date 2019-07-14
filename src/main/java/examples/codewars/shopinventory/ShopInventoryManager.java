package examples.codewars.shopinventory;

import examples.codewars.shopinventory.data.Item;
import examples.codewars.shopinventory.data.ItemWrapper;
import examples.codewars.shopinventory.functional.IUpdateItem;

import java.util.function.Consumer;

import static examples.codewars.shopinventory.functional.IUpdateItem.*;
import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;

/**
 * @see <a href="shop-inventory-manager">https://www.codewars.com/kata/shop-inventory-manager/train/java</a>
 */
public class ShopInventoryManager {

    private static final Consumer<ItemWrapper> UPDATER = item -> {
        IUpdateItem updateRule = null;
        switch (item.getItemType()) {
            case AGED_BRIE:
                updateRule = new AgedBrieUpdate();
                break;
            case SULPHURAS:
                updateRule = new SulphurasUpdate();
                break;
            case BACKSTAGE_PASS:
                switch (item.getPeriodType()) {
                    case IN_ADVANCE:
                        updateRule = new BackstagePassesInAdvandeUpdate();
                        break;
                    case SOON:
                        updateRule = new BackstagePassesSoonUpdate();
                        break;
                    case DIRECTLY:
                        updateRule = new BackstagePassesDirectlyUpdate();
                        break;
                    case PASSED:
                        updateRule = new BackstagePassedUpdate();
                        break;
                }
                break;
            case CONJURED:
                updateRule = new ConjuredUpdate();
                break;
            default:
                updateRule = new DefaultUpdate();
        }
        updateRule.update(item);
    };

    private Item[] items;

    public ShopInventoryManager(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        stream(ofNullable(items).get()).forEach(item -> UPDATER.accept(new ItemWrapper(item)));
    }
}
