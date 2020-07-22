import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPoints {
    public static void main(String[] args) {
        int[][] arr = {{3,3},{5,-1},{-2,4}};
        kClosest(arr,2);
    }
    public static int[][] kClosest(int[][] points, int K) {
        ArrayList<Integer>[] subOrdinatesList = new ArrayList[5];
        PriorityQueue<Pair<Integer,Double>> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int res = Double.compare((Double)o2.getValue(),(Double)o1.getValue());
                return res;
            }
        });
        int ind = 0;
        for(int[] point : points){
            Double dist = Math.sqrt((point[0]*point[0]) + (point[1]*point[1]));
            pq.add(new Pair(ind,dist));
            if(pq.size() > K){
                pq.remove();
            }
            ind++;
        }
        int[][] res = new int[K][2];
        int i = 0;
        while (!pq.isEmpty()){
            Pair<Integer,Double> pair = pq.remove();
            res[i++] = points[pair.getKey()];
        }
        return res;
    }
}
