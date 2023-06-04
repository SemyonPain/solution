package examples.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class L141_LinkedListCycleTest {

    @Test
    public void testLinkedListCycle() {
        L141_LinkedListCycle cycle = new L141_LinkedListCycle();

        ListNode listNode = ListNode.createListNodes(new int[]{3, 2, 0, -4});
        listNode.setPos(1);
        assertTrue(cycle.hasCycle(listNode));

        listNode = ListNode.createListNodes(new int[]{1, 2});
        listNode.setPos(0);
        assertTrue(cycle.hasCycle(listNode));

        listNode = ListNode.createListNodes(new int[]{1});
        listNode.setPos(-1);
        assertFalse(cycle.hasCycle(listNode));
    }
}
