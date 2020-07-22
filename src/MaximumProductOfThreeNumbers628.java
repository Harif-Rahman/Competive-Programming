public class MaximumProductOfThreeNumbers628 {
    public static void main(String[] args) {
        int[] arr ={-5,-4,2,3};
        maximumProduct(arr);
    }
    public static int maximumProduct(int[] A) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++){
            int curr = A[i];
            if(curr > firstMax){
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = curr;
            }else{
                if(curr > secondMax){
                    thirdMax = secondMax;
                    secondMax = curr;
                }else{
                    if(thirdMax < curr){
                        thirdMax = curr;
                    }
                }
            }
            if(curr < firstMin){
                secondMin = firstMin;
                firstMin = curr;
            }else{
                if(curr < secondMin){
                    secondMin = curr;
                }
            }
        }
        return Math.max(firstMax*secondMax*thirdMax,firstMin*secondMin*firstMax);
    }
}
