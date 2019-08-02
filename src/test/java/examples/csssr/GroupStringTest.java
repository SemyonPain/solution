package examples.csssr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class GroupStringTest {

    @Test
    public void testGroupString() {
        GroupString gs = new GroupString("сапог сарай арбуз болт бокс биржа");
        gs = new GroupString("сапог сарай арбуз болт бокс биржа Астрахань Адам Бо");
        gs = new GroupString("сапог сарай арбуз болт бокс биржа Астрахань Адам Бо д'Артаньян Демокрит с5ил");
        gs = new GroupString("сапог сарай арбуз болт бокс биржа Астрахань Адам Бо д'Артаньян Демокрит ");
    }
}
