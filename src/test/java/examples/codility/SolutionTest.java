package examples.codility;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SolutionTest {

    @Test
    public void testSolution1() {
        Solution1 solution1 = new Solution1();
        int[] array = new int[]{4, 6, 2, 2, 6, 6, 1};
        System.out.println(solution1.solution(array));
        System.out.println(solution1.newSolution(array));
        System.out.println(solution1.megaSolution(array));

        array = new int[]{4, 3, 2, 2, 6, 6, 1};
        System.out.println(solution1.solution(array));
        System.out.println(solution1.newSolution(array));
        System.out.println(solution1.megaSolution(array));

        array = new int[]{4};
        System.out.println(solution1.solution(array));
        System.out.println(solution1.newSolution(array));
        System.out.println(solution1.megaSolution(array));

        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
        System.out.println(solution1.solution(array));
        System.out.println(solution1.newSolution(array));
        System.out.println(solution1.megaSolution(array));

        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9};
        System.out.println(solution1.solution(array));
        System.out.println(solution1.newSolution(array));
        System.out.println(solution1.megaSolution(array));
    }

    @Test
    public void testSolution2() {
        Solution2 solution2 = new Solution2();

        int A = 12;
        int B = 56;
        System.out.println(solution2.solution(A, B));

        A = 56;
        B = 12;
        System.out.println(solution2.solution(A, B));

        A = 12345;
        B = 678;
        System.out.println(solution2.solution(A, B));

        A = 123;
        B = 67890;
        System.out.println(solution2.solution(A, B));

        A = 1234;
        B = 0;
        System.out.println(solution2.solution(A, B));

        A = 12345;
        B = 67890;
        System.out.println(solution2.solution(A, B));

        A = 10000000;
        B = 0;
        System.out.println(solution2.solution(A, B));

        A = 10000000;
        B = 1;
        System.out.println(solution2.solution(A, B));

        A = 10000001;
        B = 0;
        System.out.println(solution2.solution(A, B));

        A = 9999;
        B = 8888;
        System.out.println(solution2.solution(A, B));
    }
}
