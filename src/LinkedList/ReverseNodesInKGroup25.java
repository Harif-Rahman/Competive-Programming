package LinkedList;

public class ReverseNodesInKGroup25 {
    public static void main(String[] args) {
        ListNode ls = new ListNode(1);
        ls.next = new ListNode(2);
        ls.next.next = new ListNode(3);
        ls.next.next.next = new ListNode(4);
        ls.next.next.next.next = new ListNode(5);
        reverseKGroup(ls,2);
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        //2 > 1 3->4->5
        //1<2<3>4>5
        //3>2>1. 
        int len = 1;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        ListNode newHead = null;
        ListNode tail = head;
        ListNode curr = head;
        while(len - k > 0){
            //  null< 1  2 > 3 > 4
            ListNode prev = null;
            int count = k;
            while(count-- > 0 && curr.next != null){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            len -= k;
            if(newHead == null){
                newHead = prev;
            }
            tail.next = prev;
        }
        return newHead;
    }
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
