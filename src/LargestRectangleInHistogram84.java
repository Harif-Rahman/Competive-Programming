import java.util.Stack;

public class LargestRectangleInHistogram84 {
    public static void main(String[] args) {
        int[] arr = {2,1,4,5,6,7};
        largestRectangleArea1(arr);
    }
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++){
            int h = (i == len ? 0 : heights[i]);
            if (s.isEmpty() || h >= heights[s.peek()]) {
                //continue if it is a mountain
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    /**
     * some bug in this code need to check
     * @param heights
     * @return
     */
    public static int largestRectangleArea1(int[] heights) {
        Stack<Integer> leftStack = new Stack<>();
        int[] leftMinArr = new int[heights.length];
        for(int i=0;i<heights.length;i++){
            int leftMinElementInd = i;
            while(!leftStack.isEmpty() && heights[leftStack.peek()] >= heights[i]){
                leftMinElementInd = leftStack.pop();
            }
            leftStack.push(i);
            leftMinArr[i] = leftMinElementInd;
        }
        Stack<Integer> rightStack = new Stack<>();
        int[] rightMinArr = new int[heights.length];
        for(int i=heights.length-1;i>=0;i--){
            int rightElementInd = i;
            while(!rightStack.isEmpty() && heights[rightStack.peek()] >= heights[i]){
                rightElementInd = rightStack.pop();
            }
            rightStack.push(i);
            rightMinArr[i] = rightElementInd;
        }
        int maxArea = 0;

        for(int i=0;i<heights.length;i++){
            int leftLimit = leftMinArr[i];
            int rightLimt = rightMinArr[i];
            int width = rightLimt-leftLimit+1;
            int height = heights[i];
            maxArea = Math.max(maxArea,width*height);
        }
        return maxArea;
    }
}
