import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SummaryRanges228 {
    /*
    228. Summary Ranges
Medium

463

450

Favorite

Share
Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
     */
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,8,9};
        System.out.println(Integer.MAX_VALUE);
        //System.out.println(summaryRanges1(arr));
    }
    // by harif
    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        if (nums.length == 1) {
            return Collections.singletonList(String.valueOf(nums[0]));
        }
        List<String> rangesList = new ArrayList<>();
        int startVal = nums[0];
        int prevVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                if (startVal == prevVal) {
                    rangesList.add(String.valueOf(startVal));
                    if (i + 1 >= nums.length) {
                        rangesList.add(String.valueOf(nums[i]));
                    } else {
                        startVal = nums[i];
                        prevVal = nums[i];
                    }

                } else {
                    rangesList.add(startVal + "->" + prevVal);
                    if (i + 1 < nums.length) {
                        startVal = nums[i];
                        prevVal = nums[i];
                    } else {
                        rangesList.add(String.valueOf(nums[i]));
                    }
                }
            } else {
                prevVal = nums[i];
                if (i + 1 >= nums.length) {
                    rangesList.add(startVal + "->" + prevVal);
                }
            }
        }
        return rangesList;
    }
    public static List<String> summaryRanges1(int[] nums){
        List<String> list=new ArrayList();
        if(nums.length==1){
            list.add(nums[0]+"");
            return list;
        }
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
                i++;
            }
            if(a!=nums[i]){
                list.add(a+"->"+nums[i]);
            }else{
                list.add(a+"");
            }
        }
        return list;
    }

}
