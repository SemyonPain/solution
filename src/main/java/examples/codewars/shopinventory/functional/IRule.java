package examples.codewars.shopinventory.functional;

/**
 * common interface for rules, modifying item's properties
 *
 * @param <T> property's type
 */
public interface IRule<T> {

    /**
     * @return result after all changes
     */
    T get();
}
