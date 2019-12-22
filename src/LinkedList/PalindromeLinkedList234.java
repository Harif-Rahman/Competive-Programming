package LinkedList;

import java.util.Stack;

public class PalindromeLinkedList234 {

    public static void main(String[] args) {
        ListNode ls = new ListNode(1);
        ls.next = new ListNode(2);
        ls.next.next = new ListNode(3);
        ls.next.next.next = new ListNode(2);
        ls.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(ls));
    }
    /*
    find the middle element and compare first part last element to second part first element
    a   b   d   b   a
        i--       j++
        using stack to store the last elements instead of reversing the second part linked list
     */
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        // middle element
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        Stack<Integer> stack = new Stack<>();
        while(fastPointer != null && fastPointer.next != null){
            stack.push(slowPointer.val);
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        // for odd nodes
        if(fastPointer != null) slowPointer = slowPointer.next;

        while(slowPointer != null){
            if(slowPointer.val != stack.pop()) return false;
            slowPointer = slowPointer.next;
        }
        return true;
    }
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
