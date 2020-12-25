import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * same as LC 398
 * https://leetcode.com/problems/linked-list-random-node/discuss/962458/Almost-the-same-as-LC-398.-Random-Pick-Index
 */
public class LinkedListRandomNode382 {


    static class Solution {
        ListNode head = null;
        Random random ;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
            random = new Random();
        }

        /**
         * using reservoir sampling
         * for 1 elemement - 100 % probabaility
         * for 2 elemement - 50 % probabaility
         * for 3 elemement - 33 % probabaility
         * for 4 elemement - 25 % probabaility
         * @return
         */
        public int getRandom() {
            ListNode curr = head;
            int n = 0;
            int res = -1;
            while (curr != null){
                n++;
                if(random.nextInt(n) == 0){
                    res = curr.data;
                }
                curr = curr.next;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution solution = new Solution(head);

        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());

    }


    static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

}
