package examples.laackman;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class Chapter1Test {

    @Test
    public void testSolution1_1() {
        Chapter1 chapter1 = new Chapter1();
        String str = "abcdef";
        boolean result = chapter1.hasAllUnique(str);
        assertTrue(result);
        result = chapter1.hasAllUniqueWithoutAdditionalDataStructures(str);
        assertTrue(result);

        str = "abcdea";
        result = chapter1.hasAllUnique(str);
        assertFalse(result);
        result = chapter1.hasAllUniqueWithoutAdditionalDataStructures(str);
        assertFalse(result);

        str = "a";
        result = chapter1.hasAllUnique(str);
        assertTrue(result);
        result = chapter1.hasAllUniqueWithoutAdditionalDataStructures(str);
        assertTrue(result);

        str = "";
        result = chapter1.hasAllUnique(str);
        assertTrue(result);
        result = chapter1.hasAllUniqueWithoutAdditionalDataStructures(str);
        assertTrue(result);

        str = null;
        result = chapter1.hasAllUnique(str);
        assertFalse(result);
        result = chapter1.hasAllUniqueWithoutAdditionalDataStructures(str);
        assertFalse(result);
    }

    @Test
    public void testSolution1_3() {
        Chapter1 chapter1 = new Chapter1();
        String str = "abcdef";
        String result = chapter1.removeDuplicates(str);
        assertEquals(result, "abcdef");
        result = chapter1.removeDuplicatesWithoutBuffer(str);
        assertEquals(result, "abcdef");

        str = "abcdea";
        result = chapter1.removeDuplicates(str);
        assertEquals(result, "abcde");
        result = chapter1.removeDuplicatesWithoutBuffer(str);
        assertEquals(result, "abcde");

        str = "saghsfdyjrsdrtgqebarugahulewerSER'KSI3224J5 1435";
        result = chapter1.removeDuplicates(str);
        assertEquals(result, "saghfdyjrtqebulwSER'KI324J5 1");
        result = chapter1.removeDuplicatesWithoutBuffer(str);
        assertEquals(result, "saghfdyjrtqebulwSER'KI324J5 1");

        str = "a";
        result = chapter1.removeDuplicates(str);
        assertEquals(result, "a");
        result = chapter1.removeDuplicatesWithoutBuffer(str);
        assertEquals(result, "a");

        str = "";
        result = chapter1.removeDuplicates(str);
        assertEquals(result, "");
        result = chapter1.removeDuplicatesWithoutBuffer(str);
        assertEquals(result, "");

        str = null;
        result = chapter1.removeDuplicates(str);
        assertNull(result);
        result = chapter1.removeDuplicatesWithoutBuffer(str);
        assertNull(result);
    }

    @Test
    public void testSolution1_4() {
        Chapter1 chapter1 = new Chapter1();
        String s1 = "апельсин";
        String s2 = "спаниель";
        boolean result = chapter1.areAnagrams(s1, s2);
        assertTrue(result);

        s1 = "TOM MARVOLO RIDDLE ";
        s2 = "I AM LORD VOLDEMORT";
        result = chapter1.areAnagrams(s1, s2);
        assertTrue(result);

        s1 = "Аргентина манит негра";
        s2 = "аргентина манит негра";
        result = chapter1.areAnagrams(s1, s2);
        assertFalse(result);
    }

    @Test
    public void testSolution1_7() {
        Chapter1 chapter1 = new Chapter1();
        int[][] t = new int[][]{{1, 2, 3, 4}, {5, 0, 7, 8}, {9, 10, 11, 0}};
        chapter1.toZeroMatrix(t);
        assertArrayEquals(t, new int[][]{{1, 0, 3, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}});
    }

}
