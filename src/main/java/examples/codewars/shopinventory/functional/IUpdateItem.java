package examples.codewars.shopinventory.functional;

import examples.codewars.shopinventory.ShopInventoryManager;
import examples.codewars.shopinventory.data.ItemWrapper;

import static examples.codewars.shopinventory.data.ItemWrapper.PeriodType.PASSED;
import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * interface for update the item's property
 *
 * @see ShopInventoryManager
 * <p>
 * <ul>
 * <li> once the sell_in days is less then zero, quality degrades twice as fast;</li>
 * <li> the quality of an item can never be negative or increase beyond 50;</li>
 * <li> the "Aged Brie" goods actually increases in quality each passing day;</li>
 * <li> "Sulfuras" goods, being legendary items, never change their sell_in or quality values;</li>
 * <li> "backstage passes", like aged brie, increases in quality as it's sell_in value decreases;</li>
 * <li> not just that: for "backstage passes" quality increases by 2 when there are 10 days or less
 * and by 3 when there are 5 days or less but quality drops to 0 after the concert (sell_in 0 or lower).</li>
 * <li> "Conjured" items degrade in quality twice as fast as normal items.</li>
 * </ul>
 */
public interface IUpdateItem {

    int QUALITY_MIN = 0;
    int QUALITY_MAX = 50;

    // we call it "increase", though in a common business logic it is a decrease rating, to avoid mess with stacking several negative signs
    int COMMON_INCREASE_RATE = -1;
    int AGED_BRIE_INCREASE_RATE = 1;
    int SULPHURAS_INCREASE_RATE = 0;
    int BACKSTAGE_PASSES_IN_ADVANCE_RATE = 1;
    int BACKSTAGE_PASSES_SOON_RATE = 2;
    int BACKSTAGE_PASSES_DIRECTLY_RATE = 3;
    int CONJURED_INCREASE_RATE = -2;

    int PASSED_RATE_MULTIPLIER = 2;

    int COMMON_SELL_IN_INCREASE_RATE = -1;
    int SULPHURAS_SELL_IN_INCREASE_RATE = 0;

    default void update(ItemWrapper item) {
        updateQuality(item);
        updateSellIn(item);
    }

    /**
     * once the sell_in days is less then zero, quality degrades twice as fast
     */
    default int qualityIncreaseRate(ItemWrapper item) {
        return item.getPeriodType() != PASSED ? COMMON_INCREASE_RATE : COMMON_INCREASE_RATE * PASSED_RATE_MULTIPLIER;
    }

    default void updateQuality(ItemWrapper item) {
        int delta = qualityIncreaseRate(item);
        int newQuality = item.getQuality() + delta;
        item.setQuality(delta < 0 ? max(newQuality, QUALITY_MIN) : min(newQuality, QUALITY_MAX));
    }

    default void updateSellIn(ItemWrapper item) {
        item.setSellIn(item.getSellIn() + COMMON_SELL_IN_INCREASE_RATE);
    }

    class DefaultUpdate implements IUpdateItem {

    }

    /**
     * the "Aged Brie" goods actually increases in quality each passing day
     */
    class AgedBrieUpdate implements IUpdateItem {

        @Override
        public int qualityIncreaseRate(ItemWrapper item) {
            return AGED_BRIE_INCREASE_RATE;
        }
    }

    /**
     * "Sulfuras" goods, being legendary items, never change their sell_in or quality values
     */
    class SulphurasUpdate implements IUpdateItem {

        @Override
        public void updateQuality(ItemWrapper item) {
            item.setQuality(item.getQuality() + SULPHURAS_INCREASE_RATE);
        }

        @Override
        public void updateSellIn(ItemWrapper item) {
            item.setSellIn(item.getSellIn() + SULPHURAS_SELL_IN_INCREASE_RATE);
        }
    }

    /**
     * "backstage passes", like aged brie, increases in quality as it's sell_in value decreases
     */
    class BackstagePassesInAdvandeUpdate implements IUpdateItem {

        @Override
        public int qualityIncreaseRate(ItemWrapper item) {
            return BACKSTAGE_PASSES_IN_ADVANCE_RATE;
        }
    }

    /**
     * for "backstage passes" quality increases by 2 when there are 10 days or less
     */
    class BackstagePassesSoonUpdate implements IUpdateItem {

        @Override
        public int qualityIncreaseRate(ItemWrapper item) {
            return BACKSTAGE_PASSES_SOON_RATE;
        }
    }

    /**
     * for "backstage passes" quality increases by 3 when there are 5 days or less
     */
    class BackstagePassesDirectlyUpdate implements IUpdateItem {

        @Override
        public int qualityIncreaseRate(ItemWrapper item) {
            return BACKSTAGE_PASSES_DIRECTLY_RATE;
        }
    }

    /**
     * for "backstage passes" quality drops to 0 after the concert (sell_in 0 or lower)
     */
    class BackstagePassedUpdate implements IUpdateItem {

        @Override
        public int qualityIncreaseRate(ItemWrapper item) {
            return -item.getQuality();
        }
    }

    /**
     * "Conjured" items degrade in quality twice as fast as normal items
     */
    class ConjuredUpdate implements IUpdateItem {

        @Override
        public int qualityIncreaseRate(ItemWrapper item) {
            return item.getPeriodType() != PASSED ? CONJURED_INCREASE_RATE : CONJURED_INCREASE_RATE * PASSED_RATE_MULTIPLIER;
        }
    }
}
