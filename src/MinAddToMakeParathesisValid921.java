import java.util.Stack;

public class MinAddToMakeParathesisValid921 {
    /*
    921. Minimum Add to Make Parentheses Valid
Medium

498

37

Add to List

Share
Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.



Example 1:

Input: "())"
Output: 1
Example 2:

Input: "((("
Output: 3
Example 3:

Input: "()"
Output: 0
Example 4:

Input: "()))(("
Output: 4
     */
    public static void main(String[] args) {

    }

    /**
     * ACCEPTED
     *
     * @param S
     * @return
     */
    public static int minAddToMakeValid(String S) {
        Stack<Character> st = new Stack<>();
        int left = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                st.push(c);
            } else {
                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    left++;
                }
            }
        }
        return st.size() + left;
    }

    public static int minAddToMakeValid1(String S) {
        int unmatchedOpen = 0;
        int unmatchedClose = 0;

        for (char c : S.toCharArray()) {
            if (c == '(') {
                unmatchedOpen++;
            } else if (unmatchedOpen > 0)
                unmatchedOpen--;
            else {
                // This is a closed paren and there
                // isn't an open one to balance it out
                unmatchedClose++;
            }
        }
        return unmatchedClose + unmatchedOpen;
    }
}