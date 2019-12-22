public class RemoveOuterParanthesis1021 {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }
    public static String removeOuterParentheses(String S) {
        int i=0;
        int begin  = 0;
        int count=0;
        String str = "";
        while(i<S.length()){


            if(S.charAt(i) == '(')
                count++;
            else
                count--;

            if(S.charAt(i) == ')' && count > 0){
                str+=S.charAt(i);
            }
            else{

            }
            i++;
        }
        return str;
    }
}
//()()()()(())
//