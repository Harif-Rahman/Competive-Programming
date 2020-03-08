import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval57 {
    public static void main(String[] args) {
        int[][] arr = {{1,5}};
        insert(arr,new int[]{2,7});
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0)
            return intervals;

        List<int[]> ls = new ArrayList<>();
        int[] curr ;
        boolean found = false;
        if(newInterval[0] <= intervals[0][0]){
            curr = newInterval;
            found = true;
        }else{
            curr = intervals[0];
        }
        ls.add(curr);

        for(int i=0;i<intervals.length;i++){
            int[] arr = intervals[i];
            if(!found && arr[0] >= newInterval[0] ){
                // place to insert new interval
                found = true;
                if(newInterval[0] <= curr[1]){
                    curr[1] =  Math.max(curr[1], newInterval[1]);
                }else{
                    curr = newInterval;
                    ls.add(curr);
                }
                if(i == intervals.length -1){
                    ls.add(arr);
                }
            }else{
                if (arr[0] <= curr[1]) {
                    curr[1] = Math.max(curr[1], arr[1]);
                    curr = arr;
                } else {
                    curr = arr;
                    ls.add(curr);
                }
            }
        }
        if(!found){
            if (newInterval[0] <= curr[1]) {
                curr[1] = Math.max(curr[1], newInterval[1]);
            }
        }
        return ls.toArray(new int[ls.size()][]);
    }
}
