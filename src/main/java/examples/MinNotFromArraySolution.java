package examples;

public class MinNotFromArraySolution {

    public int solution(int[] A) {
        if (A == null || A.length == 0)
            return 1;
        bubble(A);
        if (A[0] > 1)
            return 1;
        int i = 0;
        while (i < A.length - 1) {
            int x = A[i];
            if (x > 0) {
                if (A[i + 1] > x + 1)
                    return x + 1;
            }
            i++;
        }
        return A[A.length - 1] + 1;
    }

    private void bubble(int[] A) {
        if (A.length < 2)
            return;
        int j = 0;
        boolean swapped = true;
        while (swapped && j < A.length - 1) {
            int i = 0;
            swapped = false;
            while (i < A.length - j - 1) {
                int a = A[i];
                int b = A[i + 1];
                if (a > b) {
                    A[i] = b;
                    A[i + 1] = a;
                    swapped = true;
                }
                i++;
            }
            j++;
        }
    }
}