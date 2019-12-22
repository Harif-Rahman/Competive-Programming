public class PartitionList86 {
    /*
    Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
1>4 >3
2>5>2
Output: 1->2->2->4->3->5
     */
    public static void main(String[] args) {
    ListNode listNode = new ListNode(1);
    listNode.next = new ListNode(4);
    listNode.next.next = new ListNode(3);
    listNode.next.next.next = new ListNode(2);
    listNode.next.next.next.next = new ListNode(5);
    listNode.next.next.next.next.next = new ListNode(2);
    partition(listNode,3);


    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(0), biggerHead = new ListNode(0);
        ListNode smaller = smallerHead, bigger = biggerHead;
        while (head != null) {
            if (head.val < x) {
                smaller = smaller.next = head;
            } else {
                bigger = bigger.next = head;
            }
            head = head.next;
        }
        // no need for extra check because of fake heads
        smaller.next = biggerHead.next; // join bigger after smaller
        bigger.next = null; // cut off anything after bigger
        return smallerHead.next;
    }
}
