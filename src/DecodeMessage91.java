public class DecodeMessage91 {
    /*
    A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
     */
    public static void main(String[] args) {
        System.out.println(decodeMessage("2123"));
        /*
        ------> :1
------> :21
------> :2
------> :12
------> :3
------> :23
5
         */
    }

    private static int decodeMessage(String str){
        int[] dp = new int[str.length()+1];
        dp[0] = 1; //dummmy
        dp[1] = str.charAt(0) == '0' ? 0 : 1;
        for(int i=2;i<=str.length();i++){
            int onedigit = Integer.parseInt(str.substring(i-1,i));
            System.out.println("------> :"+onedigit);
            int twoDigit = Integer.parseInt(str.substring(i -2 ,i));
            System.out.println("------> :"+twoDigit);
            if(onedigit >= 1){
                dp[i]+=dp[i-1];
            }
            if(twoDigit >=10 && twoDigit <=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[str.length()];
    }
}
