public class MaximumProductOfWordLength318 {
    /*
    Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:

Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
Example 2:

Input: ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".
Example 3:

Input: ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.
     */
    public static void main(String[] args) {
        String[] arr = {"abc","def"};
        maxProduct(arr);
    }

    /**
     * TC : N- ARR LENGTH M - WORD LENGTH
     *   O(M*N + N*N)
     *   SC : O(N)
     * @param words
     * @return
     */
    public static int maxProduct(String[] words) {
        int[] bit = new int[words.length];
        for(int i=0;i<words.length;i++){
            int bitCount = 0;
            for(int j=0;j<words[i].length();j++){
                bitCount |= 1 << words[i].charAt(j)-'a';
            }
            bit[i] = bitCount;
        }

        int max = 0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if((bit[i] & bit[j]) == 0){
                    max = Math.max(max,words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }


}
