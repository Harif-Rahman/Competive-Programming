import java.util.Arrays;

public class PermutationsInString567 {
    /*
    567. Permutation in String
Medium

1431

58

Add to List

Share
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.



Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False


Constraints:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
     */
    public static void main(String[] args) {
        checkInclusion("an","eidbaooo");
    }
    public static boolean checkInclusion(String s1, String s2) {
        //s1 = "ab" s2 = "eidbaooo"
        //s1 = "ab" s2 = "eidbaooo"
        char[] org = s1.toCharArray();
        Arrays.sort(org);
        String goal = String.valueOf(org);
        int i=0;
        int j= s1.length()-1;
        int[] arr = new int[26];
        for(int p=0;p<s1.length();p++){
            arr[s2.charAt(p)-'a']++;
        }
        while(j < s2.length()){
            int count = 0;
            boolean flag = true;
            for(int q=0;q<26;q++){
                int cnt = arr[q];
                while(cnt-- > 0){
                    if((char)(q+'a') != goal.charAt(count)){
                        flag = false;
                        break;
                    }
                    count++;
                }
            }
            if(flag){
                return true;
            }
            arr[s2.charAt(i)-'a']--;
            i++;
            if(++j < s2.length()){
                arr[s2.charAt(j)-'a']++;
            }
        }
        return false;
    }

    /**
     * BEST
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion1(String s1, String s2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(char c: s1.toCharArray()) {
            arr1[c-'a']++;
        }

        int start = 0, end =0;
        while(end<s2.length()) {
            arr2[s2.charAt(end) - 'a']++;
            if (end-start==s1.length()-1) {
                if (Arrays.equals(arr1,arr2)) {
                    return true;
                }
                arr2[s2.charAt(start) - 'a']--;
                start++;
            }

            end++;
        }

        return false;
    }
}
