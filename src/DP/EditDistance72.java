package DP;
/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character


Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

https://www.youtube.com/watch?v=MiqoA-yF-0M&ab_channel=BackToBackSWE
 */
public class EditDistance72 {

    public static void main(String[] args) {
        System.out.println(getMinEditDistance("horse","ros"));
    }

   /*

   2 rules
   first rule :
   if charcters are same then take diagonal value because we dont do need to donthing any chacters are matching
   second rule
   else then take the mininum value from (top,left,diagonal) + 1


       ""  r  o  s - destination
    ""  0  1  2  3     "" -> ros 3 additions
    h   1  1  2  3
    o   2  2  1  2
    r   3  2  2  2
    s   4  3  3  2
    e   5  4  4  3  -- result
   src

    */
    private static int getMinEditDistance(String src,String dest){
        int[][] arr = new int[src.length()+1][dest.length()+1];
        // insert values for first row
        for(int i=0;i<arr[0].length;i++){
            arr[0][i] = i;
        }
        for(int i=0;i<arr.length;i++){
            arr[i][0] = i;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr[0].length;j++){
                if(src.charAt(i-1) == dest.charAt(j-1)){
                    // if character is same then take diagonal
                    arr[i][j] = arr[i-1][j-1];
                }else{
                    arr[i][j] = Math.min(arr[i-1][j],Math.min(arr[i-1][j-1],arr[i][j-1])) + 1;
                }
            }
        }
        return arr[arr.length-1][arr[0].length-1];
    }
}
