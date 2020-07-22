import java.util.LinkedList;
import java.util.Queue;

public class ShortestCellPath {
    /*
[[1,1,1,1],
 [1,0,0,1],
 [0,1,0,1],
 [1,1,1,1]]


s-1 1 1 1
0 0 0 1
d1 0 1 1
*/
    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        // your code goes here
        return bfs(grid,sr,sc,tr,tc);
    }

    /**
     * BFS TC : O(N- NO OF NODES IN MATRIX
     * SC : O(N)
     * @param grid
     * @param sr
     * @param sc
     * @param tr
     * @param tc
     * @return
     */
    static int bfs(int[][] grid,int sr,int sc,int tr,int tc){
        int path = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        int rlen = grid.length;
        int clen = grid[0].length;
        int[][] dirs = {{-1,0},{0,1},{0,-1},{1,0}};
        boolean[][] visited = new boolean[rlen][clen];
        while(!queue.isEmpty()){
            int[] arr = queue.remove();
            visited[arr[0]][arr[1]] = true;
            for(int[] dir : dirs){
                int r = arr[0] + dir[0];
                int c = arr[1] + dir[1];
                if(r >= 0 && r < rlen && c >= 0 && c < clen && grid[r][c] == 1 && !visited[r][c]){
                    if(r == tr && c == tc){
                        return path+1;
                    }
                    visited[r][c] = true;
                    queue.add(new int[]{r,c});
                }
            }
            path++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,1,1,1},
                {1,0,0,1},
                {1,1,1,1}
        };
        System.out.println(shortestCellPath(grid,0,0,2,0));
    }
}
