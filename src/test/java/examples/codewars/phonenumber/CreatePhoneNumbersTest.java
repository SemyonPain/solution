package examples.codewars.phonenumber;

import examples.codewars.phonenumber.CreatePhoneNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreatePhoneNumbersTest {

    @Test
    public void phoneCreatedTest() {
        String phoneNumber = new CreatePhoneNumber().createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        assertEquals("(123) 456-7890", phoneNumber);
    }
}
