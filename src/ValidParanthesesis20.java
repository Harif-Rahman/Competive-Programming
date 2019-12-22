import java.util.Stack;

public class ValidParanthesesis20 {
    public static void main(String[] args) {
        String str = "(){}[]";
        System.out.println(isValid(str));
    }
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            switch(c){
                case '}':
                    if(st.isEmpty() || st.pop() != '{')
                        return false;
                    break;
                case ']':
                    if(st.isEmpty() || st.pop() != '[')
                        return false;
                    break;
                case ')':
                    if(st.isEmpty() || st.pop() != '(')
                        return false;
                    break;
                default:
                    st.push(c);
            }
        }
        return st.isEmpty();
    }
}
