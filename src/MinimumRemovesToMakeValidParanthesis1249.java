import java.util.Stack;

public class MinimumRemovesToMakeValidParanthesis1249 {
    /*
     Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.


Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
Example 4:

Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"
     */
    public static void main(String[] args) {
        String str = "))((";
        minRemoveToMakeValid(str);
    }
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ')' || s.charAt(i) == '('){
                if(s.charAt(i) == '('){
                    st.push(i);
                }else{
                    if(!st.isEmpty() && sb.charAt(st.peek()) != '*'){
                        st.pop();
                    }else{
                        sb.setCharAt(i,'*');
                        st.push(i);
                    }
                }
            }
        }
        while(!st.isEmpty()){
            sb.deleteCharAt(st.pop());
        }
        return sb.toString();
    }
}
