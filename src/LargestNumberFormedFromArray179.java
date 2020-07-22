import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;

public class LargestNumberFormedFromArray179 {
    public static void main(String[] args) {
        int[] arr = {3,30,34,5,9};
        largestNumber(arr);
    }
    public static String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        for(int i=0;i<strArr.length;i++){
            strArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArr,(a, b) ->{
            String str1 = a + b;
            String str2 = b + a;
            return str2.compareTo(str1);
        });

        StringBuilder sb = new StringBuilder();
        for(String str : strArr){
            sb.append(str);
        }
        return sb.toString();
    }
}
