public class TrappingRainWater {
    /*
    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
     */
    public static void main(String[] args) {

    }

    /**
     * track right max in separate arr and go from left
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int[] maxRight = new int[height.length];
        int rMax = 0;
        for(int i=height.length-1;i>=0;i--){
            maxRight[i] = rMax;
            rMax = Math.max(height[i],rMax);
        }
        int lMax = 0;
        int sum = 0;
        for(int i=0;i<height.length;i++){
            int unit = Math.min(lMax,maxRight[i]) - height[i];
            if(unit > 0){
                sum += unit;
            }
            lMax = Math.max(height[i],lMax);
        }
        return sum;
    }
}
