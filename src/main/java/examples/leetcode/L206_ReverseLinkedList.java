package examples.leetcode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 *
 *
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class L206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        int[] lists = new int[5000];
        int n = 0;
        while (current != null) {
            lists[n++] = current.val;
            current = current.next;
        }
        ListNode first = new ListNode();
        current = first;
        for (int i = n - 1; i >= 0; i--) {
            current.next = new ListNode(lists[i]);
            current = current.next;
        }
        return first.next;
    }
}
