package BFS;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill733 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0,0,0},
                {0,0,0},
        };
        floodFillDFS(arr,0,0,2,arr[0][0]);
        System.out.println(arr);
    }

    /**
     * WORKING
     * TC : O(M*N) M -ROWS N - COLS
     * SC : O(M*N)
     * @param image
     * @param r
     * @param c
     * @param newColor
     * @param startColor
     */
    public static void floodFillDFS(int[][] image, int r, int c, int newColor,int startColor) {
        if(r < 0 || r >= image.length || c < 0 || c >= image[0].length){
            return;
        }
        if(image[r][c] != startColor ){
            return;
        }
        if(image[r][c] == newColor){ // already visisted
            return;
        }
        image[r][c] = newColor;
        floodFillDFS(image,r,c+1,newColor,startColor);
        floodFillDFS(image,r,c-1,newColor,startColor);
        floodFillDFS(image,r+1,c,newColor,startColor);
        floodFillDFS(image,r-1,c,newColor,startColor);
    }
    /**BFS
     * tc : o(n*m)
     * sc : o(n*m)
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public static int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0){
            return image;
        }
        if(image[sr][sc] == newColor){
            return image; // if source color is same color dont do anything
        }

        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair(sr,sc));
        int[][] dirs = new int[][]{
                {0,-1}, // top
                {0, 1},//right
                {-1,0}, // left
                {1,0} // down
        };
        int startColor = image[sr][sc];
        image[sr][sc] = newColor;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair<Integer,Integer> pair = queue.remove();
                int r = pair.getKey();
                int c = pair.getValue();

                for(int[] dir : dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr > -1 && nr < image.length && nc > -1 && nc < image[0].length){
                        if(image[nr][nc] == startColor){
                            image[nr][nc] = newColor; // mark like visited
                            queue.add(new Pair(nr,nc));
                        }
                    }
                }
            }
        }
        return image;
    }
}
