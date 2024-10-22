package LinkedList;

import java.util.HashMap;
import java.util.Map;

/*
Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.

After doing so, return the head of the final linked list.  You may return any such answer.



(Note that in the examples below, all sequences are serializations of ListNode objects.)

Example 1:

Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.
Example 2:

Input: head = [1,2,3,-3,4]
Output: [1,2,4]
Example 3:

Input: head = [1,2,3,-3,-2]
Output: [1]
     1 >>> 0 >> 0 >>>> 1
     1     1    1      2
 */
//[1, 3, 2, -3, -2, 5, 5,-5, 1]
public class RemoveZeroSumConsecutiveNodesFromLL1171 {
    public static void main(String[] args) {
        //[1,0,0,-1,2,-1,0]
        ListNode listNode = new ListNode(-1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(-1);
        listNode.next.next.next = new ListNode(0);
        removeZeroSumSublists1(listNode);
    }

    /**
     * NICE ONE
     * @param head
     * @return
     */
    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0), cur = dummy;
        dummy.next = head;
        int prefix = 0;
        Map<Integer, ListNode> m = new HashMap<>();
        while (cur != null) {
            prefix += cur.val;            if (m.containsKey(prefix)) {
                cur =  m.get(prefix).next;
                int p = prefix + cur.val;//7
                //coming from start to remove the previous sums
                while (p != prefix) {
                    m.remove(p);
                    cur = cur.next;
                    p += cur.val;
                }
                m.get(prefix).next = cur.next;
            } else {
                m.put(prefix, cur);
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * TC : O(N) + MAX LENGTH OF SUBARRAY HAVING SUM 0
     * SC : WC: O(LENGTH OF LINKED LIST)
     * @param head
     * @return
     */
    public static ListNode removeZeroSumSublists1(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        map.put(0,dummy);
        ListNode curr = head;
        int runningSum = 0;
        while(curr != null){
            runningSum += curr.val;
            if(map.get(runningSum) != null){
                ListNode preHead = map.get(runningSum);
                ListNode temp = preHead.next;
                int prevSum = runningSum;
                while(temp != curr){
                    prevSum += temp.val;
                    map.remove(prevSum);
                    temp = temp.next;
                }
                preHead.next = curr.next;
            }else{
                map.put(runningSum,curr);
            }
            curr = curr.next;
        }
        return dummy.next;
    }





    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

}
