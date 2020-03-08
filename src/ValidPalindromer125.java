public class ValidPalindromer125 {
    public static void main(String[] args) {
        isPalindrome(".,");
    }
    public static boolean isPalindrome(String s) {
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            while(i < s.length() && (s.charAt(i) == ' ' || !isAlphaNumeric(s.charAt(i)))){
                i++;
            }
            while(j > -1 && (s.charAt(j) == ' ' || !isAlphaNumeric(s.charAt(j)))){
                j--;
            }
            if(i >j || Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))){
                return false;
            }
        }
        return true;
    }
    private static boolean isAlphaNumeric(char c){
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' &&  c <= '9');
    }
}
