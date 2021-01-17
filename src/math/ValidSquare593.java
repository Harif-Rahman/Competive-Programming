package math;

import java.util.HashSet;
import java.util.Set;

public class ValidSquare593 {
    public static void main(String[] args) {
        System.out.println(validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0,1}));
    }

    /**
     * according to the property of square all sides distance will be same except diagonal
     *
     * so there will be two unique distance we will be getting
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @return
     */
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(distance(p1,p2)); // p1,p2
        set.add(distance(p1,p3)); // p1,p3
        set.add(distance(p1,p4)); // p1,p4
        set.add(distance(p2,p3)); // p2,p3
        set.add(distance(p2,p4)); // p2,p4
        set.add(distance(p3,p4)); // p3,p4

        return set.size() == 2;
    }
    private static int distance(int[] p1,int[] p2){
        int x1 = p1[0];
        int y1 = p1[1];
        int x2 = p2[0];
        int y2 = p2[1];
        // distance formula = Math.sqrt((x2-x1)^2 - (y2-y1)^2)
        // reason why we did n't do square root is bcoz square root will be cancelling each other
        return ((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1));
    }
}
