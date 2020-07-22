public class FindPivotIndex724 {
    public static void main(String[] args) {
        int[] arr = {-1,-1,-1,-1,-1,0};
        pivotIndex(arr);
    }
    public static int pivotIndex(int[] nums) {
        int totSum = 0;
        for(int i=0;i<nums.length;i++){
            totSum += nums[i];
        }
        int sum = nums[0];
        for(int i=1;i<nums.length ;i++){
            if(sum == totSum-sum-nums[i]){
                return i;
            }
            sum+=nums[i];
        }
        return -1;
    }
}
