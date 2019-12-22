import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostionOfLargeGroups{
    public static void main(String[] args) {
        System.out.println(largeGroupPositions1("abcdddeeeeaabbbcd"));

    }
    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<S.length();){
            char c = S.charAt(i);
            int j=i+1;
            while(j < S.length() && c == S.charAt(j)) j++;
            if(j-i > 2){
                List<Integer> subLs = new ArrayList<>(2);
                subLs.add(i);
                subLs.add(j-1);
                ls.add(subLs);
            }
           i=j;
        }
        return ls;
    }
    public static List<List<Integer>> largeGroupPositions1(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        int start = 0;
        for (int i = 1; i <= S.length(); i++) {
            if (i == S.length() || S.charAt(i) != S.charAt(start)) {
                if (i - start >= 3) {
                    ans.add(Arrays.asList(start, i - 1));
                }
                start = i;
            }
        }
        return ans;
    }
}
