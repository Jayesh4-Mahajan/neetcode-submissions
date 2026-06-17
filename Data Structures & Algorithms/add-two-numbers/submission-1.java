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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        int carry = 0;
        while (n1 != null && n2 != null) {
            int sum = n1.val + n2.val + carry;
            ListNode node = new ListNode(sum);
            carry = 0;
            if (sum >= 10) {
                node.val = sum % 10;
                carry = sum / 10;
            }
            
            res.next = node;
            res = res.next;
            n1 = n1.next;
            n2 = n2.next;
        }
        while (n1 != null) {
            int sum = n1.val + carry;
            ListNode node = new ListNode(sum);
            carry = 0;
            if (sum >= 10) {
                node.val = sum % 10;
                carry = sum / 10;
            }
            res.next = node;
            res = res.next;
            n1 = n1.next;
        }
        while (n2 != null) {
            int sum = n2.val + carry;
            ListNode node = new ListNode(sum);
            carry = 0;
            if (sum >= 10) {
                node.val = sum % 10;
                carry = sum / 10;
            }
            res.next = node;
            res = res.next;
            n2 = n2.next;
        }

        if (carry != 0) {
            ListNode node = new ListNode(carry);
            res.next = node;
        }

        return dummy.next;
    }
}
