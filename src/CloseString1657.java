import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CloseString1657 {
    /*
    Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.



Example 1:

Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"
Example 2:

Input: word1 = "a", word2 = "aa"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
Example 3:

Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation: You can attain word2 from word1 in 3 operations.
Apply Operation 1: "cabbba" -> "caabbb"
Apply Operation 2: "caabbb" -> "baaccc"
Apply Operation 2: "baaccc" -> "abbccc"
Example 4:

Input: word1 = "cabbba", word2 = "aabbss"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any amount of operations.
     */

    /**
     * eg : str1 -> cabbba
     *      str2 -> abbccc
     *      after aaraging by order
     *      str1 -> aabbbc a -2 b-3 c -1
     *      str2 -> abbccc a-1 b-2 c-3
     *      here in both string str1 unique character should be same as str2
     *      two operations
     *      1) we can swap two character in a string
     *      2) we can transform every occurrence of one existing character into another existing character
     *
     *      that means we can distribute our character count to any character in particular string
     *
     *      str1 a- 2  str2 a -1 - means a need one extra character we can borrow it from c
     *
     *     for that we can sort both string by frequecies then str1 (2,3,1)  str2 (1,2,3)
     *     after sorting both will become same
     *
     * @param word1
     * @param word2
     * @return
     */
    public boolean closeStrings(String word1, String word2) {
        Set<Character> set1 = new HashSet<Character>();
        Set<Character> set2 = new HashSet<Character>();
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(char c:word1.toCharArray())
        {
            count1[c-'a']++;
            set1.add(c);
        }
        for(char d:word2.toCharArray())
        {
            count2[d-'a']++;
            set2.add(d);
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        return set1.equals(set2) && Arrays.equals(count1,count2);
    }
}
