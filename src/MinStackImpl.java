import java.util.Stack;

public class MinStackImpl {
    public static void main(String[] args) {
        MinStack<Integer> minStack = new MinStack<>();
        minStack.pushMinStack(0);
        minStack.pushMinStack(1);
        minStack.pushMinStack(0);
        System.out.println(minStack.min());
        minStack.popMinStack();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }
    private static class MinStack<T> extends Stack<Integer>{
        private int min = Integer.MAX_VALUE;
        private void pushMinStack(int val){
            //add element into the stack
            // adding equlity operator also in case if the number is coming double times 0,1,0
            if(min >= val){
                super.add(min);//add prev minimum value
                min = val;
            }
            super.add(val);
        }
        private int top(){
            return super.peek();
        }

        public int popMinStack(){
            //return top of stack
            int top = super.peek();
            if(min == top){
                super.pop();
                min = super.pop();
            }else{
                super.pop();
            }
            return top;
        }
        private int min(){
            if(super.isEmpty()){
                throw new RuntimeException("Stack is empty");
            }
            return min;
        }

    }



}
