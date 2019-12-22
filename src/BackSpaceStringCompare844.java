import java.util.Stack;

public class BackSpaceStringCompare844 {

    public static void main(String[] args) {
        backspaceCompare1("ab#d##c","ad#c");
    }
    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for(char c : S.toCharArray()){
            if(c != '#'){
                st1.push(c);
            }else{
                if(!st1.isEmpty()){
                    st1.pop();
                }
            }
        }
        for(char c : T.toCharArray()){
            if(c != '#'){
                st2.push(c);
            }else{
                if(!st2.isEmpty()){
                    st2.pop();
                }
            }
        }
        while(!st1.isEmpty() && !st2.isEmpty()){
            if(st1.pop() != st2.pop()) return false;
        }
        return st1.isEmpty() && st2.isEmpty();
    }
    private static String getString(String str) {
        int n=str.length(), count=0;
        String result="";
        for(int i=n-1; i>=0; i--) {
            char ch=str.charAt(i);
            if(ch=='#')
                count++;
            else {
                if(count>0)
                    count--;
                else {
                    result+=ch;
                }
            }
        }
        return result;
    }

    public static boolean backspaceCompare1(String S, String T) {
        return getString(S).equals(getString(T));
    }
}
