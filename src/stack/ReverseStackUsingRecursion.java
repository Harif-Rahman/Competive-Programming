package stack;

import java.util.Stack;

public class ReverseStackUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverseStackUsignRec(stack);
        System.out.println(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    /**
     * TC : O N^2
     * SC : O(N) + O(N) -- 2N > N
     * @param stack
     */
    private static void reverseStackUsignRec(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int num = stack.pop();
        reverseStackUsignRec(stack);
        insertElementAtBottom(stack,num);
    }

    private static void insertElementAtBottom(Stack<Integer> stack,int num){
        if(stack.isEmpty()){
            stack.push(num);
            return;
        }
        int temp = stack.pop();
        insertElementAtBottom(stack,num);
        stack.push(temp);
    }
}
