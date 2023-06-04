package examples.leetcode;

public class ListNode {

    int val;
    ListNode next;

    public static final int NON_EXISTING_INDEX = -1;

    private int pos = NON_EXISTING_INDEX;

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
        return val + (next == null ? "" : ", " + next);
    }

    @Override
    public int hashCode() {
        return val;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return this == null;
        }
        return obj == this;
    }

    public static ListNode createListNodes(int[] array) {
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

    void setPos(int pos) {
        this.pos = pos;
        if (pos != NON_EXISTING_INDEX) {
            ListNode tail = findTail();
            ListNode cycle = findAtIndex(pos);
            tail.next = cycle;
        }
    }

    private ListNode findTail() {
        ListNode current = this;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    private ListNode findAtIndex(int pos) {
        ListNode current = this;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        return current;
    }
}
