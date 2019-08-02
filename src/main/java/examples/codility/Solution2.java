package examples.codility;

import java.util.ArrayList;

public class Solution2 {

    public int solution(int A, int B) {
        ArrayList<Integer> digA = digits(A);
        ArrayList<Integer> digB = digits(B);
        if (digA.size() + digB.size() > 8 && !(A == 10000000 && B == 0))
            return -1;
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = digA.size() - 1;
        int j = digB.size() - 1;
        while (i >= 0 && j >= 0) {
            result.add(digA.get(i--));
            result.add(digB.get(j--));
        }
        if (i < 0)
            while (j >= 0)
                result.add(digB.get(j--));
        else if (j < 0)
            while (i >= 0)
                result.add(digA.get(i--));
        return toInt(result);
    }

    private ArrayList<Integer> digits(int x) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (x == 0)
            result.add(0);
        while (x > 0) {
            int digit = x % 10;
            result.add(digit);
            x = x / 10;
        }
        return result;
    }

    private int toInt(ArrayList<Integer> digits) {
        int result = 0;
        int multi = 1;
        for (int i = digits.size() - 1; i >= 0; i--) {
            result += digits.get(i) * multi;
            multi *= 10;
        }
        return result;
    }
}
