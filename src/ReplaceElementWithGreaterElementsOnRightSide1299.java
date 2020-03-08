import java.util.Arrays;
import java.util.Stack;

public class ReplaceElementWithGreaterElementsOnRightSide1299 {
    /*
    Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
Example 1:
Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]

Constraints:
1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5
// [120,11,120,120,123,123,-1,100,100,100]
[100, 120, 120, 120, 123, 123, 123, 1, -1, -100]
     */
    public static void main(String[] args) {
        int[] arr ={100,1,11,1,120,111,123,1,-1,-100};
        replaceElements(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void replaceElements(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                arr[st.pop()] = arr[i];
            }
            st.push(i);
        }
    }
}
