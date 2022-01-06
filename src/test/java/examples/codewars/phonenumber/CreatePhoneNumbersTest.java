package examples.codewars.phonenumber;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CreatePhoneNumbersTest {

    @Test
    public void phoneCreatedTest() {
        String phoneNumber = new CreatePhoneNumber().createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        assertEquals("(123) 456-7890", phoneNumber);
    }
}
