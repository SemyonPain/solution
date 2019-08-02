package examples.hackerrank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RobotTest {

    @Test
    public void testRobot() {
        String command = "GR";
        Robot robot = new Robot(command, 10);
        System.out.println(command + ": " + robot.isCircular());
        command = "L";
        robot = new Robot(command, 10);
        System.out.println(command + ": " + robot.isCircular());
        command = "GLLL";
        robot = new Robot(command, 10);
        System.out.println(command + ": " + robot.isCircular());
        command = "G";
        robot = new Robot(command, 10);
        System.out.println(command + ": " + robot.isCircular());
        command = "GGGGGGGGGL";
        robot = new Robot(command, 10);
        System.out.println(command + ": " + robot.isCircular());
        command = "GRGLGRGLGL";
        robot = new Robot(command, 10);
        System.out.println(command + ": " + robot.isCircular());
        command = "GRGGLRGLGG";
        robot = new Robot(command, 10);
        System.out.println(command + ": " + robot.isCircular());
    }
}
