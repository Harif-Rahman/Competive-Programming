import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones771 {
    /*
771. Jewels and Stones
Easy

1701

313

Favorite

Share
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
     */
    public static void main(String[] args) {
        numJewelsInStones1("aA","aAAbbbb");
    }

    /*
    keep iterating whether it matches the character and break brute force sol
     */
    public int numJewelsInStones(String J, String S) {
        int count =0;
        for(char c : S.toCharArray()){
            for(char c1 : J.toCharArray()){
                if(c1 == c){
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    /*
    storing jewels in hash set and check with contains
     */
    public static int numJewelsInStones1(String J, String S) {
        int res = 0;
        Set setJ = new HashSet();
        for (char j: J.toCharArray())
            setJ.add(j);
        for (char s: S.toCharArray())
            if (setJ.contains(s)) res++;
        return res;
    }

}
