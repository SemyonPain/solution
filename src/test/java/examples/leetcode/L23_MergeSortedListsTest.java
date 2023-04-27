package examples.leetcode;

import org.junit.jupiter.api.Test;

import static examples.leetcode.L23_MergeSortedLists.ListNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class L23_MergeSortedListsTest {

    @Test
    public void testMergeLists() {
        L23_MergeSortedLists merger = new L23_MergeSortedLists();
        ListNode[] lists = new ListNode[]{
                merger.createListNodes(new int[]{1, 4, 5}),
                merger.createListNodes(new int[]{1, 3, 4}),
                merger.createListNodes(new int[]{2, 6})
        };
        ListNode result = merger.mergeKLists(lists);
        assertEquals("1,1,2,3,4,4,5,6", result.toString());

        lists = new ListNode[]{};
        assertEquals("", merger.mergeKLists(lists).toString());

        lists = new ListNode[]{merger.createListNodes(new int[]{})};
        assertEquals("", merger.mergeKLists(lists).toString());
    }
}
