package examples.hackerrank;

import java.util.ArrayList;
import java.util.List;


public class Solution1 {

    /*
     * Complete the 'doesCircleExist' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY commands as parameter.
     */

    private static int x;
    private static int y;

    private static enum Dir {UP, DOWN, LEFT, RIGHT}

    private static Dir direction = Dir.UP;

    public static List<String> doesCircleExist(List<String> commands) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        for (String command : commands)
            result.add(ifCircular(command));
        return result;
    }

    private static String ifCircular(String command) {
        String commandLog = "";
        while (commandLog.length() < 40)
            commandLog += command;
        for (int i = 0; i < commandLog.length(); i++) {
            char c = commandLog.charAt(i);
            execute(c);
            if (returned())
                return "YES";
            if (exit())
                return "NO";
        }
        return "YES";
    }

    private static boolean exit() {
        return x >= 10 || x <= 10 || y >= 10 || y <= 10;
    }

    private static boolean returned() {
        return x == 0 && y == 0 && direction == Dir.UP;
    }

    private static void execute(char c) {
        if (c == 'G')
            go();
        else if (c == 'R')
            right();
        else if (c == 'L')
            left();
    }

    private static void go() {
        if (direction == Dir.UP)
            y++;
        else if (direction == Dir.RIGHT)
            x++;
        else if (direction == Dir.DOWN)
            y--;
        else if (direction == Dir.LEFT)
            x--;
    }

    private static void left() {
        if (direction == Dir.UP)
            direction = Dir.LEFT;
        else if (direction == Dir.RIGHT)
            direction = Dir.UP;
        else if (direction == Dir.DOWN)
            direction = Dir.RIGHT;
        else if (direction == Dir.LEFT)
            direction = Dir.DOWN;
    }

    private static void right() {
        if (direction == Dir.UP)
            direction = Dir.RIGHT;
        else if (direction == Dir.RIGHT)
            direction = Dir.DOWN;
        else if (direction == Dir.DOWN)
            direction = Dir.LEFT;
        else if (direction == Dir.LEFT)
            direction = Dir.UP;
    }

}