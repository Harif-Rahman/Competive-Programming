package Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KWeakestRowInAMatrix1337 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,0,0,0},
              // l       r
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };
        kWeakestRows(arr,3);
    }

    /**
     * check again
     * @param mat
     * @param k
     * @return
     */
    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] temp = new int[mat.length];
        Arrays.fill(temp,Integer.MAX_VALUE);

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int res =  temp[o2] - temp[o1];
                if(res == 0){
                    return o2-o1;
                }
                return res;
            }
        }
        );


        for(int i=0;i<mat.length;i++){
            int ind = bs(mat[i]);
            temp[i] = ind;
            pq.add(i);
            if(pq.size() > k){
                pq.remove();
            }
        }
        int[] res = new int[k];
        int resInd = res.length-1;
        while(!pq.isEmpty()){
            res[resInd--] = pq.remove();
        }
        return res;
    }
    //[0,0,0,0,0]
    //.l.r   r
    // 1 1 1
    //   l.r
    //1,1,1,1,1
    //l       l r

    //{1,1,1,0,0},
    //   lr
    // {1,1,0,0,0},
    //  l   m    l r
    private static int bs(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(arr[mid] == 1){
                left = mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}
