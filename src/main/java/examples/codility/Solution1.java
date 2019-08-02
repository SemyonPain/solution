package examples.codility;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    int solution(int[] A) {
        int N = A.length;
        int result = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (A[i] == A[j])
                    result = Math.max(result, Math.abs(i - j));
        return result;
    }

    int newSolution(int[] A) {
        int N = A.length;
        int first = 0;
        int last = N;
        while (last > first) {
            int res = check(A, 0, N);
            if (res > 0)
                return res;
            int oldLast = last;
            last = Math.min(Math.abs((last + first) / 2), last - 1);
            res = check(A, first, last);
            if (res > 0)
                return res;
            first = Math.max(Math.abs((oldLast + first) / 2), first + 1);
            res = check(A, first, oldLast);
            if (res > 0)
                return res;
        }
        return 0;
    }

    int megaSolution(int[] A) {
        int diff = 0;
        Map<Integer, Pair> map = new HashMap<Integer, Pair>();
        for (int i = 0; i < A.length; i++) {
            int key = A[i];
            Pair pair = map.get(key);
            if (pair == null)
                map.put(key, new Pair(i, null));
            else {
                pair.last = i;
                map.put(key, pair);
                int newDiff = pair.last - pair.first;
                if (newDiff > diff)
                    diff = newDiff;
            }
        }
        return diff;
    }

    private class Pair {

        Integer first;
        Integer last;

        private Pair(Integer first, Integer last) {
            this.first = first;
            this.last = last;
        }
    }

    private int check(int[] A, int first, int last) {
        for (int i = first; i <= last - 1; i++)
            for (int j = last - 1; j >= last - 1 - i; j--) {
                if (i != j && A[i] == A[j])
                    return Math.abs(i - j);
            }
        return 0;
    }
}
