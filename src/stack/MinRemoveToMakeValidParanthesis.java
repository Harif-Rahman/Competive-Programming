package stack;

import java.util.Stack;
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
 */
public class MinRemoveToMakeValidParanthesis {


    /**
     * tc : o(string length())
     * sc : two string builder and one stack
     * anyway it stores upper cost of string length
     *
     *
     * intuition
     *
     * get all the indices where it is having invalid parenthesis
     * maeking * as invalid indexes
     * then deleting the characters at the index
     * but deletecharAt takes in while loop could take o(n*n) time so creating new string builder to store resultant string
     *
     * @param s
     * @return
     */
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(i);
            }else{
                if(c == ')'){
                    if(!st.isEmpty() && s.charAt(st.peek()) == '('){
                        st.pop();
                    }else{
                        st.push(i); // adding invalid index
                    }
                }
            }
        }
        while(!st.isEmpty()){
            sb.setCharAt(st.pop(),'*');
        }
        StringBuilder res = new StringBuilder(); // creating new string builder to avoid deletechar operation
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i) != '*'){
                res.append(sb.charAt(i));
            }
        }
        return res.toString();
    }
}
