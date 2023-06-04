package examples.leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class L2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = new ListNode();
        ListNode current = first;
        boolean addOne = false;
        while (true) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (addOne ? 1 : 0);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            addOne = sum >= 10;
            current.val = addOne ? sum - 10 : sum;
            if (l1 == null && l2 == null) {
                if (addOne) {
                    current.next = new ListNode(1);
                }
                break;
            }
            current.next = new ListNode();
            current = current.next;
        }
        return first;
    }
}
