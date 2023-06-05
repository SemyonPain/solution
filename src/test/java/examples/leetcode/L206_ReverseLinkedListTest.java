package examples.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class L206_ReverseLinkedListTest {

    @Test
    public void testReverseLinkedList() {
        L206_ReverseLinkedList reverser = new L206_ReverseLinkedList();
        ListNode node = ListNode.createListNodes(new int[]{1, 2, 3, 4, 5});
        ListNode result = reverser.reverseList(node);
        assertEquals("5, 4, 3, 2, 1", result.toString());

        node = ListNode.createListNodes(new int[]{1, 2});
        result = reverser.reverseList(node);
        assertEquals("2, 1", result.toString());

        node = ListNode.createListNodes(new int[]{});
        result = reverser.reverseList(node);
        assertEquals(node.toString(), result.toString());
    }
}
