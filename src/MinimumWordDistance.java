import java.util.HashMap;
import java.util.Map;
/*
Input : s = “geeks for geeks contribute practice,practice geeks”, w1 = “geeks”, w2 = “practice”
Output : 1

leftMap  ={{geeks,6},{for,1},{contribute,3},{practice,5}
rightMap ={{geeks,0},{for,1},{contribute,3},{practice,4}

There is only one word between closest occurrences of w1 and w2.
Input : s = “the quick the brown quick brown the frog”, w1 = “quick”, w2 = “frog”
Output : 2
 */
public class MinimumWordDistance {


    public static void main(String[] args) {
        String[] words = {"geeks","for","contribute","practice","cdx","geeks"};
        getMinDistance(words,"geeks","practice");
    }
    private static int getMinDistance(String[] words,String str1,String str2){
        Map<String,Integer> rightMinMap = new HashMap<>();
        for(int i=words.length-1;i>=0;i--){
            rightMinMap.put(words[i],i);
        }
        Map<String,Integer> leftMinMap = new HashMap<>();
        int min = Integer.MIN_VALUE;
        for(int i=0;i<words.length;i++){
            leftMinMap.put(words[i],i);

            boolean word1 = words[i].equals(str1);
            boolean word2 = words[i].equals(str2);
            if(word1 || word2){
                String target = word1 ? str2 : str1;
                if(leftMinMap.get(target) != null && rightMinMap.get(target) != null){
                    if(leftMinMap.get(target) < i && i < rightMinMap.get(target)){
                        min = Math.min(leftMinMap.get(target)-i-1, rightMinMap.get(target)-i-1);
                        continue;
                    }
                }
                min = leftMinMap.get(target) == null ? rightMinMap.get(target)-i-1 : i - leftMinMap.get(target) -1 ;
            }
        }
        return min;
    }
}
