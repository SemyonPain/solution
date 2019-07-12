package examples.codewars;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CreatePhoneNumbersTest {

    @Test
    public void phoneCreatedTest() {
        String phoneNumber = new CreatePhoneNumber().createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        assertEquals("(123) 456-7890", phoneNumber);
    }
}
