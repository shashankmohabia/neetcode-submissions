/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbersWithCarry(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;
        int v = carry;
        ListNode ln1 = null;
        ListNode ln2 = null;
        if (l1 != null) {
            v+= l1.val;
            ln1 = l1.next;
        }
        if (l2 != null) {
            v+= l2.val;
            ln2 = l2.next;
        }
        ListNode node = new ListNode(v%10, addTwoNumbersWithCarry(ln1, ln2, v/10));
        return node;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        return addTwoNumbersWithCarry(l1, l2, 0);
    }
}
