import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray442 {
    public static void main(String[] args) {
        int[] arr = {10,2,5,10,9,1,1,4,3,7};
        findDuplicates(arr);
    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int ind = Math.abs(nums[i]) - 1;
            if(nums[ind] < 0){
                ls.add(Math.abs(nums[i]));
            }
            nums[ind] = -nums[ind];
        }
        return ls;

    }
}
