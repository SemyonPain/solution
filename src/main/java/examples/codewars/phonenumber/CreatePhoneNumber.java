package examples.codewars.phonenumber;

import static java.lang.String.format;
import static java.util.Arrays.stream;

/**
 * @see <a href="create-phone-number">https://www.codewars.com/kata/create-phone-number/train/java</a>
 * <p>
 * Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in
 * the form of a phone number.
 * <p>
 * Example: Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890" The returned
 * format must be correct in order to complete this challenge. Don't forget the space after the closing parenthesis!
 */
public class CreatePhoneNumber {

    private static final String PHONE_FORMAT = "(%d%d%d) %d%d%d-%d%d%d%d";

    public String createPhoneNumber(int[] numbers) {
        return format(PHONE_FORMAT, stream(numbers).boxed().toArray(Integer[]::new));
    }
}
