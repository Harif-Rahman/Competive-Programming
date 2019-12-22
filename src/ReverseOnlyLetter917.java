public class ReverseOnlyLetter917 {
    public static void main(String[] args) {
        String str = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(str));
    }
    public static String reverseOnlyLetters(String S) {
        char[] c = S.toCharArray();
        int i=0,j=S.length()-1;
        while(i<j){
            while(i<j && !((c[i] >= 'a' && c[i] <= 'z') || (c[i] >= 'A' && c[i] <= 'Z'))){
                i++;
            }
            while(i<j && !((c[i] >= 'A' && c[i] <= 'Z') || (c[i] >= 'a' && c[i] <= 'z'))){
                j--;
            }
            char temp = c[i];
            c[i]= c[j];
            c[j] = temp;
            i++;j--;
        }
        return new String(c);
    }
}

