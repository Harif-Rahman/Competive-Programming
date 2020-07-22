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

    /**
     * ACCEPTED
     * TC : O(N)
     * SC : O(1)
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode dummyhead1 = new ListNode(-1);
        dummyhead1.next = head;
        ListNode head1 = dummyhead1;
        ListNode dummyhead2 = new ListNode(-1);
        ListNode head2 = dummyhead2;
        ListNode curr = head;
        while(curr != null){
            System.out.println("cxzs");
            if(curr.val < x){
                // attach to head1
                head1.next = curr;
                //move head1
                head1 = head1.next;
            }else{
                // attach to head2
                head2.next = curr;
                //move head2
                head2 = head2.next;
            }
            curr = curr.next;
        }
        head2.next = null;
        head1.next = dummyhead2.next;
        return dummyhead1.next;
    }
}
