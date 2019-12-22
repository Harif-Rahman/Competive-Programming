public class RotateLinkedList {

    public static void main(String[] args) {
        ListNode ls = new ListNode(1);
        ls.next = new ListNode(2);
        ls.next.next = new ListNode(3);
        ls.next.next.next = new ListNode(4);
        ls.next.next.next.next = new ListNode(5);
        ls.next.next.next.next.next = new ListNode(6);
        ListNode head = rotateLL(ls,4);
        System.out.println(head);

    }
    private static ListNode rotateLL(ListNode tempHead,int k){
        ListNode temp = tempHead;
        while(--k != 0){
            temp = temp.next;
        }
        ListNode kthNode = temp;

        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = tempHead;
        ListNode head = kthNode.next;
        kthNode.next = null;
        return head;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
