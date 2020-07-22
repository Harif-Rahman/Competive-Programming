import java.util.ArrayList;
import java.util.List;

public class PartitionLabels763 {
    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij" ;
        partitionLabels(str);
    }

    /**
     * TC : O(N= length of string)
     * SC : O(26) constant space
     * @param S
     * @return
     */
    public static List<Integer> partitionLabels(String S) {
        int[] arr = new int[26];
        for(int i=0;i<S.length();i++){
            arr[S.charAt(i)-'a'] = i;
        }
        List<Integer> ls = new ArrayList<>();
        int currentMax = 0;
        for(int i=0;i<S.length();i++){
            int count = 0;
            while(i<=currentMax){
                if(arr[S.charAt(i)-'a'] > currentMax){
                    currentMax = arr[S.charAt(i)-'a'];
                }
                i++;
                count++;
            }
            currentMax++;
            i--;
            ls.add(count);
        }
        return ls;
    }
}
