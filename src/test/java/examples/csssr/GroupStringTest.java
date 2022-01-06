package examples.csssr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GroupStringTest {

    @Test
    public void testGroupString() {
        GroupString gs = new GroupString("сапог сарай арбуз болт бокс биржа");
        gs = new GroupString("сапог сарай арбуз болт бокс биржа Астрахань Адам Бо");
        gs = new GroupString("сапог сарай арбуз болт бокс биржа Астрахань Адам Бо д'Артаньян Демокрит с5ил");
        gs = new GroupString("сапог сарай арбуз болт бокс биржа Астрахань Адам Бо д'Артаньян Демокрит ");
    }
}
