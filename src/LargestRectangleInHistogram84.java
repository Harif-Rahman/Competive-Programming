import java.util.Stack;

public class LargestRectangleInHistogram84 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,3,2};
        largestRectangleArea(arr);
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
}
