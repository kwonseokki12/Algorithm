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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = list1.val > list2.val ? list2 : list1;
        ListNode cur = head;
        ListNode target = list1.val > list2.val ? list1 : list2;

        while (cur.next != null && target != null) {
            if (cur.next.val >= target.val) {
                ListNode next = target.next;
                target.next = cur.next;
                cur.next = target;
                target = next;
            } else {
                cur = cur.next;
            }
        }

        if (target != null) {
            cur.next = target;
        }

        return head;
    }
}