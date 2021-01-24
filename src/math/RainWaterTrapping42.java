package math;

public class RainWaterTrapping42 {

    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int[] maxRightArr = new int[height.length];
        int maxRight = 0;
        for(int i=height.length-1;i>=0;i--){
            maxRightArr[i] = maxRight;
            maxRight = Math.max(maxRight,height[i]);
        }
        int maxLeft = 0;int sum = 0;
        for(int i=0;i<height.length;i++){
            int minHeighBetweenLeftAndright = Math.min(maxLeft,maxRightArr[i]);
            // if left max or right max is less than current value then water will not stay
            /*
            |
            |   ____
            |   |  |       __
            |   |  |      |  |    __
            ____|__|______|__|____|_|_____
                left      curr    right
                max       hight.  max

                here water will not stay

            |   ____
            |   |  |              ___
            |   |  |       __     | |
            |   |  |      |  |    | |
            ____|__|______|__|____|_|_____
                left      curr    right
                max       hight.  max
                here water will stay
            */

            if(height[i] < minHeighBetweenLeftAndright){
                sum += minHeighBetweenLeftAndright - height[i];
            }
            maxLeft = Math.max(maxLeft,height[i]);
        }
        return sum;
    }}
