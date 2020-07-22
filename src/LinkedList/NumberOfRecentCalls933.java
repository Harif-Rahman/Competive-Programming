package LinkedList;

public class NumberOfRecentCalls933 {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        recentCounter.ping(1);
        recentCounter.ping(80);
        System.out.println(recentCounter.ping(2200));
        System.out.println(recentCounter.ping(2300));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
    static class RecentCounter {
        ListNode head;
        ListNode tail;
        int size = 0;
        public RecentCounter() {
            head = new ListNode(-1);
            tail = head;
        }

        public int ping(int t) {
            tail.next = new ListNode(t);
            tail = tail.next;
            size++;

            if(head.val == -1){
                head = head.next;
            }
            ListNode temp = head;
            while (temp != null && temp.val < t - 3000){
                temp = temp.next;
                head = temp;
                size--;
            }
            return size;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
