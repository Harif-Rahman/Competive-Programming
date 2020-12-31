package BFS;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutOffTreesForGolfEvents675 {
    public static void main(String[] args) {
        List<List<Integer>> forest = new ArrayList<>();
        forest.add(new ArrayList<>(Arrays.asList(54581641,64080174,24346381,69107959)));
        forest.add(new ArrayList<>(Arrays.asList(86374198,61363882,68783324,79706116)));
        forest.add(new ArrayList<>(Arrays.asList(668150,92178815,89819108,94701471)));
        forest.add(new ArrayList<>(Arrays.asList(83920491,22724204,46281641,47531096)));
        forest.add(new ArrayList<>(Arrays.asList(89078499,18904913,25462145,60813308)));
        System.out.println(cutOffTree(forest));
    }

    /**
     * sort tree by heights and then try to find the next tree using bfs
     * @param forest
     * @return
     */
    public static int cutOffTree(List<List<Integer>> forest) {
        //Validation
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        for(int row = 0; row < forest.size(); row++){
            for(int col = 0; col < forest.get(row).size(); col++){
                int height = forest.get(row).get(col);
                if (height > 1){
                    pq.offer(new int[]{row, col, height} );
                }
            }
        }

        int res = 0;
        int[] prev = new int[]{0,0};
        while(!pq.isEmpty()){
            int[] cur = pq.remove();
            int step = bfs(prev, cur, forest);
            if (step < 0) return -1;
            res += step;
            prev[0] = cur[0];
            prev[1] = cur[1];
        }

        return res;

    }

    private static int bfs(int[] start, int[] end, List<List<Integer>> forest){

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        int step = 0;
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i<size; i++){
                int[] cur = queue.remove();
                visited[cur[0]][cur[1]] = true;

                if (cur[0] == end[0] && cur[1] == end[1]){
                    return step;
                }
                //Left
                if (isValid(cur[0], cur[1]-1, forest, visited)){
                    visited[cur[0]][cur[1]-1] = true;
                    queue.offer(new int[]{cur[0], cur[1]-1});
                }
                //Top
                if (isValid(cur[0]-1, cur[1], forest, visited)){
                    visited[cur[0]-1][cur[1]] = true;
                    queue.offer(new int[]{cur[0]-1, cur[1]});
                }
                //Right
                if (isValid(cur[0], cur[1]+1, forest, visited)){
                    visited[cur[0]][cur[1]+1] = true;
                    queue.offer(new int[]{cur[0], cur[1]+1});
                }
                //Down
                if (isValid(cur[0]+1, cur[1], forest, visited)){
                    visited[cur[0]+1][cur[1]] = true;
                    queue.offer(new int[]{cur[0]+1, cur[1]});
                }
            }

            step++;

        }
        return -1;
    }

    private static boolean isValid(int x, int y, List<List<Integer>> forest, boolean[][] visited){
        return (x >= 0 && x < forest.size() && y >= 0 && y < forest.get(0).size() && forest.get(x).get(y) > 1 && !visited[x][y]);
    }
}
