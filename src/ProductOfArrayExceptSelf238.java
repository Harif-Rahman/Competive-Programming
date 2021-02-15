public class ProductOfArrayExceptSelf238 {
    /**
     * TC : Two passes still considers as o(array length)
     * sc : o(array length)
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }

        int[] rightProd = new int[nums.length];


        int prod = 1;
        for(int i=nums.length-1;i>=0;i--){
            prod *= nums[i];
            rightProd[i] = prod;
        }
        prod = 1;
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int leftProd = prod;
            prod *= nums[i];
            int rprod = i+1 <nums.length ? rightProd[i+1] : 1;
            res[i] = leftProd * rprod;
        }
        return res;
    }
}
