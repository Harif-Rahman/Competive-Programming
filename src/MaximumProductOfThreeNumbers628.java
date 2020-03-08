public class MaximumProductOfThreeNumbers628 {
    public static void main(String[] args) {
        int[] arr = {-4,-3,-2,-1,60};
        maximumProduct(arr);
    }
    public static int maximumProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        for(int i : nums){
            if(i > firstMax){
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = i;
            }else{
                if(i > secondMax){
                    thirdMax = secondMax;
                    secondMax = i;
                }else{
                    if(i > thirdMax){
                        thirdMax = i;
                    }
                }
            }

        }
        return firstMax*secondMax*thirdMax;
    }
}
