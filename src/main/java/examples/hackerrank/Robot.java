package examples.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Robot {

    private int maxLength;

    private String command;

    private Coordinates c;

    private int n;

    public Robot(String command, int maxLength) {
        if (command == null || command.isEmpty() || command.length() > maxLength || command.matches("[^GLR]"))
            throw new RuntimeException("Incorrect incoming data: " + command);
        this.command = command;
        this.maxLength = maxLength;
        c = new Coordinates(maxLength);
        c.dir = Coordinates.Dir.UP;
    }

    public boolean isCircular() {
        int i = 0;
        int max = 4 * maxLength * maxLength;
        while (n < max) {
            Coordinates cNew = new Coordinates(maxLength);
            cNew.x = c.x;
            cNew.y = c.y;
            cNew.dir = c.dir;
            logCommand(cNew);
            if (checkDuplicates())
                return true;
            if (exit())
                return false;
            char ch = command.charAt(i);
            execute(ch);
            if (++i >= command.length())
                command += command;
        }
        return true;
    }

    private List<Coordinates> log = new ArrayList<Coordinates>();

    private void logCommand(Coordinates c) {
        log.add(c);
    }

    private boolean exit() {
        return Math.abs(c.x) >= maxLength || Math.abs(c.y) >= maxLength;
    }

    private void execute(char ch) {
        switch (ch) {
            case 'L':
                c.left();
                break;
            case 'R':
                c.right();
                break;
            case 'G':
                c.go();
                n++;
        }
    }

    private boolean checkDuplicates() {
        int[] a = new int[2];
        a[0] = -1;
        a[1] = -1;
        for (int i = 0; i < log.size() - 1; i++)
            if (c.equals(log.get(i)))
                if (a[0] < 0)
                    a[0] = i;
                else {
                    a[1] = i;
                    break;
                }
        if (a[1] < 0)
            return false;
        String s1 = command.substring(a[0], a[1]);
        String s2 = command.substring(a[1], log.size() - 1);
        return s1.equals(s2);
    }

    private static class Coordinates {

        private int x;
        private int y;

        private enum Dir {UP, DOWN, LEFT, RIGHT}

        private Dir dir;

        private int maxLength;

        private Coordinates(int maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Coordinates))
                return false;
            Coordinates that = (Coordinates) o;
            return x == that.x && y == that.y && dir == that.dir;
        }

        @Override
        public int hashCode() {
            int dirInt = 0;
            switch (dir) {
                case UP:
                    dirInt = 1;
                    break;
                case RIGHT:
                    dirInt = 2;
                    break;
                case DOWN:
                    dirInt = 3;
                    break;
                case LEFT:
                    dirInt = 4;
            }
            int max = maxLength > 4 ? maxLength : maxLength + 5;
            return max * max * x + max * y + dirInt;
        }

        private void go() {
            switch (dir) {
                case UP:
                    y++;
                    break;
                case RIGHT:
                    x++;
                    break;
                case DOWN:
                    y--;
                    break;
                case LEFT:
                    x--;
            }
        }

        private void left() {
            switch (dir) {
                case UP:
                    dir = Dir.LEFT;
                    break;
                case RIGHT:
                    dir = Dir.UP;
                    break;
                case DOWN:
                    dir = Dir.RIGHT;
                    break;
                case LEFT:
                    dir = Dir.DOWN;
            }
        }

        private void right() {
            switch (dir) {
                case UP:
                    dir = Dir.RIGHT;
                    break;
                case RIGHT:
                    dir = Dir.DOWN;
                    break;
                case DOWN:
                    dir = Dir.LEFT;
                    break;
                case LEFT:
                    dir = Dir.UP;
            }
        }
    }
}
