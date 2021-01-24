package math;

import java.util.Arrays;

public class AssignCookies455 {
    public static void main(String[] args) {

    }

    /**
     * intuition
     * sort both cookies and content
     * so we can get the minimum greedy content for the child it is looking for
     * once it is satisified then go to next child
     *  tc : glog g + s log s + max(g,s)
     *  sc : o(1)
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int first = 0;
        int second = 0;
        int res = 0;
        while(first < g.length && second < s.length){

            if(g[first] <= s[second]){
                res++;
                first++;// increment child content
            }
            second++; // increment cookies
        }
        return res;

    }
}
