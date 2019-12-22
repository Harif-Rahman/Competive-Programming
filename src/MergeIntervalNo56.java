import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class MergeIntervalNo56 {
    public static void main(String[] args) {
        int[][] arr ={
                {1,3},{2,6},{8,10},{15,18}
        };
        mergeInterval(arr);
    }
    static int[][] mergeInterval(int[][] intervals){
        if(intervals.length <=1)
            return intervals;
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] newInterval = intervals[0];
        List<int[]> result =new ArrayList<>();
        result.add(newInterval);
        for(int i = 1;i<intervals.length;i++){
            int[] tempArr = intervals[i];
            if(tempArr[0] <= newInterval[1]){
                newInterval[1] = Math.max(newInterval[1],tempArr[1]);
            }else{
                newInterval = tempArr;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}