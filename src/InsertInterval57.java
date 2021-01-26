import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval57 {
    public static void main(String[] args) {
        int[][] arr = {{1,5}};
        insert(arr,new int[]{2,7});
    }


    /**
     * NICE ONE
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public static int[][] insert1(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            // we could mutate newInterval here also
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // add the union of intervals we got
        result.add(newInterval);

        // add all the rest
        while (i < intervals.length){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
    /**
     * WORKING BUT NOT ELEGANT
     * @param intervals
     * @param newInterval
     * @return
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals == null || intervals.length == 0){
            return new int[][]{newInterval};
        }
        List<int[]> ls = new ArrayList<>();

        boolean newIntervalProcessed = false;
        int i = 1;
        int[] curr;
        if(newInterval[0] < intervals[0][0]){
            curr = newInterval;
            ls.add(curr);
            newIntervalProcessed = true;
            i--;
        }else{
            curr = intervals[0];
            ls.add(curr);
        }

        while(i<intervals.length){
            int[] interval = intervals[i];
            if(!newIntervalProcessed && newInterval[0] <= interval[0]){
                boolean flag = true;
                // if both start time same then take end time
                if(newInterval[0] == interval[0] && newInterval[1] > interval[1]){
                    flag = false;
                }
                if(flag){
                    interval = newInterval;
                    newIntervalProcessed = true;
                    i--;
                }
            }

            int startTime = interval[0];
            int endTime = interval[1];

            if(curr[1] >= startTime){
                //merge
                curr[1] = Math.max(endTime,curr[1]);
            }else{
                curr = interval;
                ls.add(curr);
            }
            i++;
        }
        // if new interval still not processed then add it to list
        if(!newIntervalProcessed){
            if(curr[1] >= newInterval[0]){
                //merge
                curr[1] = Math.max(newInterval[1],curr[1]);
            }else{
                ls.add(newInterval);
            }
        }

        return ls.toArray(new int[ls.size()][ls.get(0).length]);
    }
}
