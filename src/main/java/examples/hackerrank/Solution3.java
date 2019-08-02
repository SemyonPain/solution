package examples.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Solution3 {

    /*
     * Complete the 'gemstones' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY rocks as parameter.
     */

    public static int gemstones(List<String> rocks) {
    // Write your code here
        int result = 0;
        String letters = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            if (allContains(rocks, c))
                result++;
        }
        return result;
    }

    private static boolean allContains(List<String> rocks, char c) {
        for (String rock : rocks)
            if (rock.indexOf(c) < 0)
                return false;
        return true;   
    }

}