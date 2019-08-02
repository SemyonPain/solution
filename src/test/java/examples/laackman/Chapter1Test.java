package examples.laackman;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class Chapter1Test {

    @Test
    public void testSolution1_1() {
        Chapter1 chapter1 = new Chapter1();
        String str = "abcdef";
        boolean result = chapter1.hasAllUnique(str);
        Assert.assertTrue(result);
        result = chapter1.hasAllUniqueWithoutAdditionalDataStructures(str);
        Assert.assertTrue(result);

        str = "abcdea";
        result = chapter1.hasAllUnique(str);
        Assert.assertFalse(result);
        result = chapter1.hasAllUniqueWithoutAdditionalDataStructures(str);
        Assert.assertFalse(result);

        str = "a";
        result = chapter1.hasAllUnique(str);
        Assert.assertTrue(result);
        result = chapter1.hasAllUniqueWithoutAdditionalDataStructures(str);
        Assert.assertTrue(result);

        str = "";
        result = chapter1.hasAllUnique(str);
        Assert.assertTrue(result);
        result = chapter1.hasAllUniqueWithoutAdditionalDataStructures(str);
        Assert.assertTrue(result);

        str = null;
        result = chapter1.hasAllUnique(str);
        Assert.assertFalse(result);
        result = chapter1.hasAllUniqueWithoutAdditionalDataStructures(str);
        Assert.assertFalse(result);
    }

    @Test
    public void testSolution1_3() {
        Chapter1 chapter1 = new Chapter1();
        String str = "abcdef";
        String result = chapter1.removeDuplicates(str);
        Assert.assertEquals(result, "abcdef");
        result = chapter1.removeDuplicatesWithoutBuffer(str);
        Assert.assertEquals(result, "abcdef");

        str = "abcdea";
        result = chapter1.removeDuplicates(str);
        Assert.assertEquals(result, "abcde");
        result = chapter1.removeDuplicatesWithoutBuffer(str);
        Assert.assertEquals(result, "abcde");

        str = "saghsfdyjrsdrtgqebarugahulewerSER'KSI3224J5 1435";
        result = chapter1.removeDuplicates(str);
        Assert.assertEquals(result, "saghfdyjrtqebulwSER'KI324J5 1");
        result = chapter1.removeDuplicatesWithoutBuffer(str);
        Assert.assertEquals(result, "saghfdyjrtqebulwSER'KI324J5 1");

        str = "a";
        result = chapter1.removeDuplicates(str);
        Assert.assertEquals(result, "a");
        result = chapter1.removeDuplicatesWithoutBuffer(str);
        Assert.assertEquals(result, "a");

        str = "";
        result = chapter1.removeDuplicates(str);
        Assert.assertEquals(result, "");
        result = chapter1.removeDuplicatesWithoutBuffer(str);
        Assert.assertEquals(result, "");

        str = null;
        result = chapter1.removeDuplicates(str);
        Assert.assertNull(result);
        result = chapter1.removeDuplicatesWithoutBuffer(str);
        Assert.assertNull(result);
    }

    @Test
    public void testSolution1_4() {
        Chapter1 chapter1 = new Chapter1();
        String s1 = "апельсин";
        String s2 = "спаниель";
        boolean result = chapter1.areAnagrams(s1, s2);
        Assert.assertTrue(result);

        s1 = "TOM MARVOLO RIDDLE ";
        s2 = "I AM LORD VOLDEMORT";
        result = chapter1.areAnagrams(s1, s2);
        Assert.assertTrue(result);

        s1 = "Аргентина манит негра";
        s2 = "аргентина манит негра";
        result = chapter1.areAnagrams(s1, s2);
        Assert.assertFalse(result);
    }

    @Test
    public void testSolution1_7() {
        Chapter1 chapter1 = new Chapter1();
        int[][] t = new int[][]{{1, 2, 3, 4}, {5, 0, 7, 8}, {9, 10, 11, 0}};
        chapter1.toZeroMatrix(t);
        Assert.assertArrayEquals(t, new int[][]{{1, 0, 3, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}});
    }

}
