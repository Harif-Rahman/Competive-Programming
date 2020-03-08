import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature739 {
        /*

Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
         */
    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        dailyTemperatures(arr);
    }

    /**
     * ACCEPTED same as next greater element
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                int popped = st.pop();
                temperatures[popped] = i-popped;
            }
            st.push(i);
        }
        while (!st.isEmpty()){
            temperatures[st.pop()] =0;
        }
        return temperatures;
    }
}
