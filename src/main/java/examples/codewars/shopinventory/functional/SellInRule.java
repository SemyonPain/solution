package examples.codewars.shopinventory.functional;

import examples.codewars.shopinventory.data.ItemWrapper;

import static examples.codewars.shopinventory.data.ItemWrapper.ItemType.SULPHURAS;

/**
 * set of rules for update item's sell_in, user must combine them in chain
 * <p>
 * NOTE! order of rules makes sense, they has to be applied due to actual business logic
 */
public class SellInRule implements IRule<Integer> {

    private static final int COMMON_SELL_IN_INCREASE_RATE = -1;
    private static final int SULPHURAS_SELL_IN_INCREASE_RATE = 0;

    private int sellInDelta;
    private ItemWrapper item;

    public SellInRule(ItemWrapper item) {
        this.item = item;
    }

    @Override
    public Integer get() {
        return sellInDelta;
    }

    /*
     * "Sulfuras" goods, being legendary items, never change their sell_in or quality values
     */
    public SellInRule rateByType() {
        sellInDelta = item.getItemType() != SULPHURAS ? COMMON_SELL_IN_INCREASE_RATE : SULPHURAS_SELL_IN_INCREASE_RATE;
        return this;
    }
}
