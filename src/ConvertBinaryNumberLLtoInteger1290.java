public class ConvertBinaryNumberLLtoInteger1290 {
    /*
    Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.



Example 1:


Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10
Example 2:

Input: head = [0]
Output: 0
Example 3:

Input: head = [1]
Output: 1
Example 4:

Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
Output: 18880
Example 5:

Input: head = [0,0]
Output: 0
     */
    public static void main(String[] args) {
        ListNode ls = new ListNode(1);
        ls.next = new ListNode(0);
        ls.next.next = new ListNode(1);
        ls.next.next.next = new ListNode(1);
        getDecimalValue2(ls);
    }
    //------me
    public int getDecimalValue(ListNode head) {
        ListNode rev = reverseLLIter(head);
        int n=0;
        int result = 0;
        while(rev != null){
            result += (rev.val) * Math.pow(2,n++);
            rev = rev.next;
        }
        return result;
    }
    private ListNode reverseLLIter(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode next;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    //--------------------------



    public static int getDecimalValue1(ListNode head) {
        int num = 0;
        while(head != null) {
            num = num*2 + head.val;
            head = head.next;
        }
        return num;
    }
    public static int getDecimalValue2(ListNode head) {
        int num = 0;
        while(head!=null) {
            num <<= 1;
            num += head.val;
            head = head.next;
        }
        return num;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //---
}
