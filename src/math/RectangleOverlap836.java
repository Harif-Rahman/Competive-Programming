package math;

public class RectangleOverlap836 {
    public static void main(String[] args) {
        int[] rec1 = {0,0,1,1}, rec2 = {2,2,3,3};
        isRectangleOverlap(rec1,rec2);
    }
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int p1x = rec1[0];
        int p1y = rec1[1];
        int p2x = rec1[2];
        int p2y = rec1[3];

        int q1x = rec2[0];
        int q1y = rec2[1];
        int q2x = rec2[2];
        int q2y = rec2[3];


        return !(p2y < q1y && q2y < p1y && p2x < q1x && q2x < p1x);
        //rec1[0] < rec2[2] && rec2[0] < rec1[2] && rec1[1] < rec2[3] && rec2[1] < rec1[3];
    }


}
