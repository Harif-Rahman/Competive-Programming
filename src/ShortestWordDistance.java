import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance {
    /*
    Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.
     */
    public static void main(String[] args) {
        String[] arr = {"practice", "makes", "perfect", "coding", "makes"};
        getShortestWordDistance(arr,"coding","makes");

    }
    private static int getShortestWordDistance(String[] arr,String str1,String str2){
        int n = -1,m = -1;
        int i = 0;
        int min = Integer.MAX_VALUE;
        for(String str : arr){
            if(str.equals(str1)){
                n = i;
                if(m != -1){
                    min = Math.min(n,m);
                }
            }else{
                m = i;
                if(n != -1){
                    min = Math.min(n,m);
                }
            }

            i++;
        }
        return min;

        // coding 3
        // makes 1 4

    }
}
