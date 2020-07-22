import java.util.Stack;

public class ValidateParanthesis678 {
    public static void main(String[] args) {
        String str = "(*))";
    }
    public boolean checkValidString1(String s) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else {
                // for case '*' and ')'
                if (low > 0) { // low will be consider * as close bracket
                    low--;
                }
                high += s.charAt(i) == ')' ? -1 : 1;
            }
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
    }
    public static boolean checkValidString(String s) {
        Stack<Integer> leftID = new Stack<>();
        Stack<Integer> starID = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                leftID.push(i);
            else if (ch == '*')
                starID.push(i);
            else {
                if (leftID.isEmpty() && starID.isEmpty())   return false;
                if (!leftID.isEmpty())
                    leftID.pop();
                else
                    starID.pop();
            }
        }
        while (!leftID.isEmpty() && !starID.isEmpty()) {
            if (leftID.pop() > starID.pop())
                return false;
        }
        return leftID.isEmpty();
    }

}
