package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveLL1171 {
    public static void main(String[] args) {// 1 3 -3 -2
        ListNode ls = new ListNode(1); //  0 1 4 1 0
        ls.next = new ListNode(2); //fp
        ls.next.next = new ListNode(3);
        ls.next.next.next = new ListNode(-3);
        ls.next.next.next.next = new ListNode(-2);
        removeZeroSumSublists(ls);
    }
    public static ListNode removeZeroSumSublists(ListNode head) {
        int[] arr = new int[2];
        zeroSumSubArray(head,arr);
        //first pointer goes upto first index
        ListNode fp1 = head;
        int i=0;
        for(i=0;i< arr[0] -1;i++){
            fp1 = fp1.next;
        }
        ListNode sp1 = fp1;
        for(int j =i;j <= arr[1] - i;j++){
            sp1 = sp1.next;
        }
        if(arr[0] == 0){
            head = sp1;
        }else{
            fp1.next = sp1.next;
        }

        return head;
        //second pointer


    }
    private static int[] zeroSumSubArray(ListNode head,int[] arr){
        ListNode current = head;
        int sum =0;
        Map<Integer,Integer> hm = new HashMap<>();
        for (int i =0;current != null; i++) {
            Integer prevStoredSumIndex = hm.get(sum);
            if(prevStoredSumIndex == null){
                hm.put(sum,i);
                sum+=current.val;
            }else {
                arr[0] = prevStoredSumIndex;
                arr[1] = i - 1;
            }
            current = current.next;
        }
        return arr;
    }
    public ListNode removeZeroSumSublists1(ListNode head) {
        if(head == null) return head;
        Map<Integer, ListNode> sums = new HashMap<>();
        int sum = 0;
        ListNode curr = head;
        while(curr != null){
            sum += curr.val;
            if(sum == 0)
                head = curr.next;
            if(sums.containsKey(sum)){
                int tmp = sum;
                ListNode n = sums.get(sum).next;
                while(n != curr){
                    tmp += n.val;
                    sums.remove(tmp);
                    n = n.next;
                }
                sums.get(sum).next = curr.next;
                return removeZeroSumSublists1(head);
            }
            sums.put(sum, curr);
            curr = curr.next;
        }
        return head;
    }
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
