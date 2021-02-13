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

    /**
     * WORKING
     * TC : O(S1 + S2 LENGTH)
     * SC : O(26)  --> O(1) constant
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int i=0;
        int[] s1Arr = new int[26];
        for(int p =0;p<s1.length();p++){
            s1Arr[s1.charAt(p) - 'a']++;
        }

        int[] s2Arr = new int[26];

        for(int p =0;p<s1.length()-1;p++){
            s2Arr[s2.charAt(p) - 'a']++;
        }


        for(int j=s1.length()-1;j<s2.length();j++){
            s2Arr[s2.charAt(j) - 'a']++;
            if(isAnagram(s1Arr,s2Arr)){
                return true;
            }
            s2Arr[s2.charAt(i) - 'a']--;
            i++;
        }
        return false;
    }
    private static boolean isAnagram(int[] s1Arr,int[] s2Arr){
        for(int i=0;i<26;i++){
            if(s1Arr[i] != s2Arr[i]){
                return false;
            }
        }
        return true;
    }
}
