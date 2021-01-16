import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
You are given an array of distinct integers arr and an array of integer arrays pieces, where the integers in pieces are distinct. Your goal is to form arr by concatenating the arrays in pieces in any order. However, you are not allowed to reorder the integers in each array pieces[i].

Return true if it is possible to form the array arr from pieces. Otherwise, return false.



Example 1:

Input: arr = [85], pieces = [[85]]
Output: true
Example 2:

Input: arr = [15,88], pieces = [[88],[15]]
Output: true
Explanation: Concatenate [15] then [88]
Example 3:

Input: arr = [49,18,16], pieces = [[16,18,49]]
Output: false
Explanation: Even though the numbers match, we cannot reorder pieces[0].
Example 4:

Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
Output: true
Explanation: Concatenate [91] then [4,64] then [78]
Example 5:

Input: arr = [1,3,5,7], pieces = [[2,4,6,8]]
Output: false
 */
public class checkArrayFormation {
    public static void main(String[] args) {
        int[] arr = {91,4,64,8,78,2};
        int[][] pieces = new int[][]{
                {78,2},
                {4,64,8},
                {91}
        };
        System.out.println(canFormArray(arr, pieces));
    }
    /*
    Idea:
Store the pieces in such a way that each array piece is linked and first element of each piece
 should be accessible in O(1) time. Hence using a HashMap.
  Then, traverse the arr and check if
   each value exits as a key (rest of the values in the arraylist of each key will be indexed over & checked in for loop)
eg:

arr = [91,4,64,8,78,2], pieces = [[78,2],[4,64,8],[91]]
HashMap:
78-> [2]
4-> [64,8]
91-> new ArrayList()

[91,4,64,8,78,2] (91 exists as a key)
 ^
[91,4,64,8,78,2] (4 exists as a key and [64,8] an array of values)
    ^  * *
[91,4,64,8,78,2] (78 exists as a key and [2] an array of values )
		    ^ *
     */
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap();

        for(int[] list:pieces){
            hm.put(list[0],new ArrayList());
            for(int i=1;i<list.length;i++)
                hm.get(list[0]).add(list[i]);
        }
        int index = 0;
        while(index<arr.length){
            if(!hm.containsKey(arr[index]))
                return false;

            ArrayList<Integer> list = hm.get(arr[index++]);
            for(int val:list){
                if(index>=arr.length || val!=arr[index])
                    return false;
                index++;
            }
        }
        return true;
    }
}
