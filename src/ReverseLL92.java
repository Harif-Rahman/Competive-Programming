public class ReverseLL92 {

    public static void main(String[] args) {
        ListNode ls = new ListNode(1);
        ls.next = new ListNode(2);
        ls.next.next = new ListNode(3);
        ls.next.next.next = new ListNode(4);
        ls.next.next.next.next = new ListNode(5);
        reverseBetween(ls, 1, 3);
    }


    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode trav = dummy;
        for (i = 0; i < m - 1; i++) {
            trav = trav.next;
        }
        ListNode prev = null;
        ListNode current = trav.next;
        ListNode next = null;
        while (i < n) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }
      /*  if (prev!= null && head == prev.next) {
                prev.next = next;
        } else {
            head.next = prev;
        }*/

        trav.next = next;
        return dummy.next;


    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
