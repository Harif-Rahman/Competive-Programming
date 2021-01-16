import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels763 {
    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij" ;
        partitionLabels1(str);
    }

    /**
     * TC : LENGTH OF STRING
     * SC O(26)
     * @param S
     * @return
     */
    public static List<Integer> partitionLabels1(String S) {
        List<Integer> ls = new ArrayList<>();
        if(S == null){
            return ls;
        }
        Map<Character,Integer> lastPositionIndexMap = new HashMap<>();
        for(int i=0;i<S.length();i++){
            lastPositionIndexMap.put(S.charAt(i),i);
        }
        int i=0;
        while(i<S.length()){
            int maxLength = i;
            int start = i;
            while(i <= maxLength){
                maxLength = Math.max(maxLength,lastPositionIndexMap.get(S.charAt(i)));
                i++;
            }
            ls.add(maxLength-start+1);
        }
        return ls;
    }
}
