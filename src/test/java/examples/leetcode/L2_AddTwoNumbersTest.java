package examples.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class L2_AddTwoNumbersTest {

    @Test
    public void testAddTwoNumbers() {
        L2_AddTwoNumbers adder = new L2_AddTwoNumbers();
        ListNode l1 = ListNode.createListNodes(new int[]{2, 4, 3});
        ListNode l2 = ListNode.createListNodes(new int[]{5, 6, 4});
        ListNode result = adder.addTwoNumbers(l1, l2);
        assertEquals("7, 0, 8", result.toString());

        l1 = ListNode.createListNodes(new int[]{0});
        l2 = ListNode.createListNodes(new int[]{0});
        result = adder.addTwoNumbers(l1, l2);
        assertEquals("0", result.toString());

        l1 = ListNode.createListNodes(new int[]{9, 9, 9, 9, 9, 9, 9});
        l2 = ListNode.createListNodes(new int[]{9, 9, 9, 9});
        result = adder.addTwoNumbers(l1, l2);
        assertEquals("8, 9, 9, 9, 0, 0, 0, 1", result.toString());
    }
}
