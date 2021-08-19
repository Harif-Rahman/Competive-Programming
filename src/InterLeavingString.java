public class InterLeavingString {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int [] arr = new int[26];

        for(char c : s1.toCharArray()){
            arr[c-'a']++;
        }
        for(char c : s2.toCharArray()){
            arr[c-'a']++;
        }

        for(char c : s3.toCharArray()){
            arr[c-'a']--;
        }
        for(int i=0;i<26;i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
    /*

    Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false

        aabc    dbbca




    "aadbbbaccc"
    ""
    "aadbbbaccc"

    "
     */

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc","dbbca","aadbbcbcac"));
    }
}
