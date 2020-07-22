import java.util.Stack;

public class RemoveKDigits402 {
    /*
    Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
     */
    public static void main(String[] args) {
        System.out.println(removeKdigits("112", 1));
    }

    /**
     * accepted with tc :
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int i=0;
        while(i < num.length()){
            while(k > 0 && !st.isEmpty() && st.peek() > num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
            i++;
        }
        while (k-- > 0 && !st.isEmpty()){
            // for cases like 11111 or 11112
            st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.toString().equals("") ? "0" : sb.toString();
    }
}
