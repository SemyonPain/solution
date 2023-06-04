package examples.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class L23_MergeSortedListsTest {

    @Test
    public void testMergeLists() {
        L23_MergeSortedLists merger = new L23_MergeSortedLists();
        ListNode[] lists = new ListNode[]{
                ListNode.createListNodes(new int[]{1, 4, 5}),
                ListNode.createListNodes(new int[]{1, 3, 4}),
                ListNode.createListNodes(new int[]{2, 6})
        };
        ListNode result = merger.mergeKLists(lists);
        assertEquals("1, 1, 2, 3, 4, 4, 5, 6", result.toString());

        lists = new ListNode[]{};
        assertEquals("0", merger.mergeKLists(lists).toString());

        lists = new ListNode[]{ListNode.createListNodes(new int[]{})};
        assertEquals("0", merger.mergeKLists(lists).toString());
    }
}
