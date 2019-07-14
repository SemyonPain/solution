package examples.codewars.shopinventory.functional;

import examples.codewars.shopinventory.ShopInventoryManager;
import examples.codewars.shopinventory.data.ItemWrapper;

import static examples.codewars.shopinventory.data.ItemWrapper.ItemType.BACKSTAGE_PASS;
import static examples.codewars.shopinventory.data.ItemWrapper.ItemType.SULPHURAS;
import static examples.codewars.shopinventory.data.ItemWrapper.PeriodType.PASSED;

/**
 * set of rules for update item's quality, user must combine them in chain
 * <p>
 * NOTE! order of rules makes sense, they has to be applied due to actual business logic
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
public class QualityRule implements IRule<Integer> {

    private static final int QUALITY_MIN = 0;
    private static final int QUALITY_MAX = 50;

    // we call it "increase", though in a common business logic it is a decrease rating, to avoid mess with stacking several negative signs
    private static final int COMMON_INCREASE_RATE = -1;
    private static final int AGED_BRIE_INCREASE_RATE = 1;
    private static final int SULPHURAS_INCREASE_RATE = 0;
    private static final int BACKSTAGE_PASSES_IN_ADVANCE_RATE = 1;
    private static final int BACKSTAGE_PASSES_SOON_RATE = 2;
    private static final int BACKSTAGE_PASSES_DIRECTLY_RATE = 3;
    private static final int CONJURED_INCREASE_RATE = -2;

    private static final int PASSED_RATE_MULTIPLIER = 2;

    private int qualityDelta;
    private ItemWrapper item;

    public QualityRule(ItemWrapper item) {
        this.item = item;
    }

    @Override
    public Integer get() {
        return qualityDelta;
    }

    /*
     * the "Aged Brie" goods actually increases in quality each passing day
     * "Conjured" items degrade in quality twice as fast as normal items
     */
    public QualityRule rateByType() {
        switch (item.getItemType()) {
            case AGED_BRIE:
                qualityDelta = AGED_BRIE_INCREASE_RATE;
                break;
            case CONJURED:
                qualityDelta = CONJURED_INCREASE_RATE;
                break;
            case DEFAULT:
                qualityDelta = COMMON_INCREASE_RATE;
        }
        return this;
    }

    /*
     * "backstage passes", like aged brie, increases in quality as it's sell_in value decreases;
     * not just that: for "backstage passes" quality increases by 2 when there are 10 days or less
     * and by 3 when there are 5 days or less but quality drops to 0 after the concert (sell_in 0 or lower)
     */
    public QualityRule modifyRateByPeriodType() {
        if (item.getItemType() == BACKSTAGE_PASS)
            switch (item.getPeriodType()) {
                case IN_ADVANCE:
                    qualityDelta = BACKSTAGE_PASSES_IN_ADVANCE_RATE;
                    break;
                case SOON:
                    qualityDelta = BACKSTAGE_PASSES_SOON_RATE;
                    break;
                case DIRECTLY:
                    qualityDelta = BACKSTAGE_PASSES_DIRECTLY_RATE;
                    break;
                case PASSED:
                    qualityDelta = -item.getQuality();
            }
        return this;
    }

    /*
     * once the sell_in days is less then zero, quality degrades twice as fast
     */
    public QualityRule modifyRateBySellIn() {
        if (qualityDelta < 0 && item.getPeriodType() == PASSED)
            qualityDelta *= PASSED_RATE_MULTIPLIER;
        return this;
    }

    /*
     * the quality of an item can never be negative or increase beyond 50, except for "Sulphuras" items
     */
    public QualityRule checkIfAbsoluteResultInBorders() {
        if (item.getItemType() != SULPHURAS) {
            int newQuality = item.getQuality() + qualityDelta;
            // example: current quality is 1, qualityDelta is -4: newQuality is -3, shortage is -3 ->
            // to receive quality 0 our rate has to be -4 + (0 - (-3)) = -1
            if (newQuality < QUALITY_MIN)
                qualityDelta += QUALITY_MIN - newQuality;
                // example: current quality is 49, qualityDelta is 3: newQuality is 52, overrun is 2 ->
                // to receive quality 50 our rate has to be 3 - (52 - 50) = 1
            else if (newQuality > QUALITY_MAX)
                qualityDelta -= newQuality - QUALITY_MAX;
        }
        return this;
    }

    /*
     * "Sulfuras" goods, being legendary items, never change their sell_in or quality values
     */
    public QualityRule dropRateForLegendaryItems() {
        if (item.getItemType() == SULPHURAS)
            qualityDelta = SULPHURAS_INCREASE_RATE;
        return this;
    }

}
