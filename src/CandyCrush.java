import java.util.Stack;

public class CandyCrush {
    public static void main(String[] args) {
        String str = "aabbccddeeedcba";

    }
    private static String solve(String str){
        Stack<Character> stack = new Stack<>();
        int i=0;
        int count = 1;
        while (i < str.length()){
            char c= str.charAt(i);
            if(i > 0){
                if(str.charAt(i-1) == str.charAt(i)){
                    count++;
                }else{
                    if(count > 2){
                        char ch = str.charAt(i-1);
                        while (!stack.isEmpty() && stack.peek() == ch){
                            stack.pop();
                        }
                    }
                    count = 1;
                }
            }
            stack.push(c);
            i++;
        }

        return str;
    }
}
