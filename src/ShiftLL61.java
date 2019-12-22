public class ShiftLL61 {
    /*
    Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
     */
    public static void main(String[] args) {
        ListNode ls = new ListNode(1);
        ls.next = new ListNode(2);
        ls.next.next = new ListNode(3);
        ls.next.next.next = new ListNode(4);
        ls.next.next.next.next = new ListNode(5);
        rotateRight(ls, 2);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    /*
     ----------- me
     find size after that get to (size - k )the node hold and get the last node point the last node to first node and break the kthnode
     */


    public static ListNode rotateRight(ListNode tempHead, int k) {
        if (tempHead == null)
            return null;
        int size = getSizeLL(tempHead);
        if (size == 1 || size == k || k % size == 0)
            return tempHead;
        k = k % size;
        int br = size - k;
        ListNode temp = tempHead;
        while (--br != 0) {
            temp = temp.next;
        }
        ListNode kthNode = temp;
        while (temp.next != null) {
            temp = temp.next;
        }
        ListNode head = kthNode.next;
        temp.next = tempHead;
        kthNode.next = null;
        return head;
    }

    private static int getSizeLL(ListNode ln) {
        int size = 0;
        while (ln != null) {
            ln = ln.next;
            size++;
        }
        return size;
    }

    /*
    here what happened is getting the size and holding the last node after going to kth node point head to kth node.next and keth next to null
     */
    public static ListNode rotateRight1(ListNode head, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int i;
        for (i = 0; fast.next != null; i++)//Get the total length
            fast = fast.next;

        for (int j = i - n % i; j > 0; j--) //Get the i-n%i th node
            slow = slow.next;

        fast.next = dummy.next; //Do the rotation
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }


}
