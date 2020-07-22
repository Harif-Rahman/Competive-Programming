public class ShiftingLetters848 {

    /*
    We have a string S of lowercase letters, and an integer array shifts.

Call the shift of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').

For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.

Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x times.

Return the final string after all such shifts to S are applied.

Example 1:

Input: S = "abc", shifts = [3,5,9]
Output: "rpl"
Explanation:
We start with "abc".
After shifting the first 1 letters of S by 3, we have "dbc".
After shifting the first 2 letters of S by 5, we have "igc".
After shifting the first 3 letters of S by 9, we have "rpl", the answer.
Note:

1 <= S.length = shifts.length <= 20000
0 <= shifts[i] <= 10 ^ 9
     */
    public static void main(String[] args) {
        String str = "mkgfzkkuxownxvfvxasy";
        int[] arr = { 505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513};
        System.out.println(shiftingLetters(str,arr));
    }

    /**
     * BEST TC : O(N)
     * SC (INPUT STRING LENGTH)
     * @param S
     * @param shifts
     * @return
     */
    public static String shiftingLetters(String S, int[] shifts) {
        char[] s = S.toCharArray();
        int prefixSum = 0;
        for(int i=shifts.length-1; i > -1 ;i--){
            prefixSum += shifts[i] % 26;
            int shift = prefixSum  % 26;
            if(s[i] + shift > 'z'){ // when it goes out of boundary
                s[i] = (char)((shift - ('z' - s[i])) + 'a' - 1);
            }else{
                s[i] =(char)(s[i] + shift);
            }
        }
        return new String(s);
    }
    // a- 97 z -122
    //117 + 17 134
}
