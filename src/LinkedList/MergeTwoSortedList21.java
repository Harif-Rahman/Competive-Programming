package LinkedList;

public class MergeTwoSortedList21 {
    /*
    Input: 1->2->4,
           2->3->4
    Output: 1->1->2->3->4->4
     */
    public static void main(String[] args) {
        ListNode ls = new ListNode(1);
        ls.next = new ListNode(2);
        ls.next.next = new ListNode(4);
        ListNode ls2 = new ListNode(1);
        ls2.next = new ListNode(3);
        ls2.next.next = new ListNode(4);
        mergeTwoLists(ls, ls2);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(-1);
        ListNode head = curr;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
              curr.next = l2;
              l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
