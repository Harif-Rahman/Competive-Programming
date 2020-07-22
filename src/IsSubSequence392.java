import java.util.Arrays;

public class IsSubSequence392 {
    public static void main(String[] args) {
        isSubsequence("axc","ahbgdc");
    }
    public static boolean isSubsequence(String s, String t) {
        int[] arr = new int[26];
        Arrays.fill(arr,Integer.MAX_VALUE);
        for(int i=0;i<s.length();i++){
            arr[t.charAt(i)-'a'] = i;
        }

        for(int i=1;i<s.length();i++){
            if(arr[s.charAt(i-1)-'a'] > arr[s.charAt(i)-'a']){
                System.out.println(s.charAt(i));
                return false;
            }
        }
        return true;
    }
}
