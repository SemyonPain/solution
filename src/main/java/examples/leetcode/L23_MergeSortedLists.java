package examples.leetcode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * <p>
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 * <p>
 * Input: lists = []
 * Output: []
 * Example 3:
 * <p>
 * Input: lists = [[]]
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 */
public class L23_MergeSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode first = new ListNode();
        if (lists.length == 0) {
            return first;
        }
        int n = findElementsNumber(lists);
        ListNode current = first;
        for (int i = 0; i < n; i++) {
            int indexMin = findMinFirst(lists);
            ListNode newMin = lists[indexMin];
            current.val = newMin.val;
            lists[indexMin] = lists[indexMin].next;
            if (i < n - 1) {
                current.next = new ListNode();
                current = current.next;
            }
        }
        return first;
    }

    private int findElementsNumber(ListNode[] lists) {
        int i = 0;
        for (ListNode listNode : lists) {
            int j = 0;
            while (listNode != null) {
                j++;
                listNode = listNode.next;
            }
            i += j;
        }
        return i;
    }

    private int findMinFirst(ListNode[] lists) {
        int index = firstNotNull(lists);
        int indexMin = index;
        for (int i = 0; i < lists.length; i++) {
            if (i != index && lists[i] != null && lists[i].val < lists[indexMin].val) {
                indexMin = i;
            }
        }
        return indexMin;
    }

    private int firstNotNull(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                return i;
            }
        }
        throw new RuntimeException();
    }

    public ListNode createListNodes(int[] array) {
        ListNode first = new ListNode();
        ListNode current = first;
        for (int i = 0; i < array.length; i++) {
            current.val = array[i];
            if (i < array.length - 1) {
                current.next = new ListNode();
                current = current.next;
            }
        }
        return first;
    }

    public static class ListNode {
        private int val;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return (val == 0 ? "" : String.valueOf(val)) +
                    (next == null || next.val == 0 ? "" : "," + next);
        }
    }
}
