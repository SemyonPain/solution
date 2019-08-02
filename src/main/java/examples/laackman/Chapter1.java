package examples.laackman;

import java.util.HashMap;

// Arrays and Strings
public class Chapter1 {

    // 1.1 if a string has all unique characters
    public boolean hasAllUnique(String str) {
        if (str == null)
            return false;
        HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.get(c) == null)
                map.put(c, true);
            else
                return false;
        }
        return true;
    }

    // 1.1 if a string has all unique characters without additional data structures
    public boolean hasAllUniqueWithoutAdditionalDataStructures(String str) {
        if (str == null)
            return false;
        for (int i = 0; i < str.length(); i++) {
            char ci = str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                char cj = str.charAt(j);
                if (ci == cj)
                    return false;
            }
        }
        return true;
    }

    // 1.3 remove duplicate characters
    public String removeDuplicates(String str) {
        if (str == null)
            return null;
        HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.get(c) == null)
                sb.append(c);
            map.put(c, true);
        }
        return sb.toString();
    }

    // 1.3 remove duplicate characters without additional buffer
    public String removeDuplicatesWithoutBuffer(String str) {
        if (str == null)
            return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ci = str.charAt(i);
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                char cj = str.charAt(j);
                if (ci == cj) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                sb.append(ci);
        }
        return sb.toString();
    }

    // are the strings palyndroms or not
    public boolean arePalyndroms(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;
        if (s1.length() != s2.length())
            return false;
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(n - i);
            if (c1 != c2)
                return false;
        }
        return true;
    }

    // are the strings anagrams or not
    public boolean areAnagrams(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;
        if (s1.isEmpty())
            return s2.isEmpty();
        if (s1.length() != s2.length())
            return false;
        HashMap<Character, Integer> map1 = strToMap(s1);
        HashMap<Character, Integer> map2 = strToMap(s2);
        for (char c : map1.keySet()) {
            if (!map1.get(c).equals(map2.get(c)))
                return false;
        }
        return true;
    }

    private HashMap<Character, Integer> strToMap(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer n = map.get(s);
            if (n == null)
                n = 1;
            else
                n++;
            map.put(c, n);
        }
        return map;
    }

    private void toZeroRow(int[][] t, int j) {
        for (int i = 0; i < t.length; i++)
            t[i][j] = 0;
    }

    private void toZeroColumn(int[][] t, int i) {
        for (int j = 0; j < t[0].length; j++)
            t[i][j] = 0;
    }

    // 1.7 if element is 0, set all elements in the same row and column to 0
    public void toZeroMatrix(int[][] t) {
        if (t == null)
            return;
        int m = t.length;
        int n = t[0].length;
        boolean[] flags = new boolean[m];
        int i = 0;
        while (i < m) {
            if (flags[i]) {
                i++;
                continue;
            }
            int j = 0;
            while (j < n) {
                if (t[i][j] == 0) {
                    flags[i] = true;
                    toZeroRow(t, j);
                    toZeroColumn(t, i);
                    j++;
                }
                j++;
            }
            i++;
        }
    }

}
