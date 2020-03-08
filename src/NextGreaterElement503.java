import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement503 {
    /*
    iven a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number;
The second 1's next greater number needs to search circularly, which is also 2.

// [120,11,120,120,123,123,-1,100,100,100]
     */
    public static void main(String[] args) {
        int[] arr ={100,1,11,1,120,111,123,1,-1,-100};
        System.out.println(Arrays.toString(nextGreaterElements(arr)));
    }

    /**
     * ACCEPTED
     * @param arr
     * @return
     */
    private static int[] nextGreaterElements(int[] arr) {
        int[] res = new int[arr.length];
        Arrays.fill(res,-1);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length*2;i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i % arr.length]){
                res[st.pop()] = arr[i % arr.length];
            }
            if( i < arr.length){
                st.push(i % arr.length);
            }
        }
        return res;
    }
    //[18,6,6,6,1,-1]
}
