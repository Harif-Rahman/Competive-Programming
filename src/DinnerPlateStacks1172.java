import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class DinnerPlateStacks1172 {
    /*
    You have an infinite number of stacks arranged in a row and numbered (left to right) from 0, each of the stacks has the same maximum capacity.

Implement the DinnerPlates class:

DinnerPlates(int capacity) Initializes the object with the maximum capacity of the stacks.
void push(int val) pushes the given positive integer val into the leftmost stack with size less than capacity.
int pop() returns the value at the top of the rightmost non-empty stack and removes it from that stack, and returns -1 if all stacks are empty.
int popAtStack(int index) returns the value at the top of the stack with the given index and removes it from that stack, and returns -1 if the stack with that given index is empty.
Example:

Input:
["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
[[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
Output:
[null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]

Explanation:
DinnerPlates D = DinnerPlates(2);  // Initialize with capacity = 2
D.push(1);
D.push(2);
D.push(3);
D.push(4);
D.push(5);         // The stacks are now:  2  4
                                           1  3  5
                                           ﹈ ﹈ ﹈
D.popAtStack(0);   // Returns 2.  The stacks are now:     4
                                                       1  3  5
                                                       ﹈ ﹈ ﹈
D.push(20);        // The stacks are now: 20  4
                                           1  3  5
                                           ﹈ ﹈ ﹈
D.push(21);        // The stacks are now: 20  4 21
                                           1  3  5
                                           ﹈ ﹈ ﹈
D.popAtStack(0);   // Returns 20.  The stacks are now:     4 21
                                                        1  3  5
                                                        ﹈ ﹈ ﹈
D.popAtStack(2);   // Returns 21.  The stacks are now:     4
                                                        1  3  5
                                                        ﹈ ﹈ ﹈
D.pop()            // Returns 5.  The stacks are now:      4
                                                        1  3
                                                        ﹈ ﹈
D.pop()            // Returns 4.  The stacks are now:   1  3
                                                        ﹈ ﹈
D.pop()            // Returns 3.  The stacks are now:   1
                                                        ﹈
D.pop()            // Returns 1.  There are no stacks.
D.pop()            // Returns -1.  There are still no stacks.
     */
    public static void main(String[] args) {
        DinnerPlates dinnerPlates = new DinnerPlates(2);
        for(int i=1;i<=5;i++){
            dinnerPlates.push(i);
        }
        dinnerPlates.popAtStack(0);
        dinnerPlates.push(20);
        dinnerPlates.push(21);
        dinnerPlates.popAtStack(0);
        dinnerPlates.popAtStack(2);
        dinnerPlates.pop();
        dinnerPlates.pop();
        dinnerPlates.pop();
    }
    static class DinnerPlates {
        int capacity;
        List<Stack<Integer>> stacks;
        TreeSet<Integer> pushable;
        TreeSet<Integer> popable;


        public DinnerPlates(int cap) {
            capacity = cap;
            stacks = new ArrayList<>();
            pushable = new TreeSet<>();
            popable = new TreeSet<>();
        }

        public void push(int val) {
            if (pushable.isEmpty()) {
                pushable.add(stacks.size());
                stacks.add(new Stack<>());
            }
            int index = pushable.first();
            Stack<Integer> stack = stacks.get(index);
            stack.push(val);
            popable.add(index);
            if (stack.size() == capacity) {
                pushable.remove(index);
            }
        }

        public int pop() {
            if (popable.size() == 0) {
                return -1;
            }
            int index = popable.last();
            return popAtStack(index);
        }

        public int popAtStack(int index) {
            if (!popable.contains(index)) {
                return -1;
            }
            Stack<Integer> stack = stacks.get(index);
            int res = stack.pop();
            pushable.add(index);
            if (stack.size() == 0) {
                popable.remove(index);
            }
            return res;
        }
    }
}
