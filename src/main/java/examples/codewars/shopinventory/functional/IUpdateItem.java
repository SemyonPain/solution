package examples.codewars.shopinventory.functional;

import examples.codewars.shopinventory.ShopInventoryManager;
import examples.codewars.shopinventory.data.ItemWrapper;

/**
 * functional interface for update the item's property
 *
 * @see ShopInventoryManager
 */
@FunctionalInterface
public interface IUpdateItem {

    void update(ItemWrapper item);

    /**
     * NOTE! set of rules and their order rely on current business logic
     * <p>
     * In case of logic changing, new rules should be added instead of old ones rewriting
     */
    IUpdateItem UPDATER = item -> {
        int qualityDelta = new QualityRule(item).rateByType()
                .modifyRateByPeriodType()
                .modifyRateBySellIn()
                .checkIfAbsoluteResultInBorders()
                .dropRateForLegendaryItems()
                .get();
        int sellINDelta = new SellInRule(item).rateByType()
                .get();
        item.setQuality(item.getQuality() + qualityDelta);
        item.setSellIn(item.getSellIn() + sellINDelta);
    };
}
