public class ReverseVowelOfString345 {
    public static String reverseVowels(String s) {
        int start =0;
        int end = s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        while(start < end){
            while(start < end && !isVowel(sb.charAt(start))){
                start++;
            }
            while(start < end && !isVowel(sb.charAt(end))){
                end--;
            }
            char temp = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
        return sb.toString();
    }
    private static boolean isVowel(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    public static void main(String[] args) {
        reverseVowels("harifrahman");
    }
}
