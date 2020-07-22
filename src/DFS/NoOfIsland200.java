package DFS;

public class NoOfIsland200 {
    /*
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
     */
    public static void main(String[] args) {
        char[][] board = {
                {'1', '1', '0' ,'0','0'},
                {'1', '1', '0' ,'0','0'},
                {'0', '0', '1' ,'0','0'},
                {'0', '0', '0' ,'1','1'},
        };
        System.out.println(numIslands(board));
    }
        public static int numIslands(char[][] grid) {
            if(grid == null || grid.length == 0){
                return 0;
            }
            int rlen = grid.length;
            int clen = grid[0].length;
            int res = 0;
            for(int i=0;i<rlen;i++){
                for(int j=0;j<clen;j++){
                    if(grid[i][j] == '1'){
                        res++;
                        dfs(grid,i,j);
                    }
                }
            }
            return res;
        }
        private static void dfs(char[][] grid,int r,int c){
            if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
                return;
            }
            if(grid[r][c] == '0'){
                return;
            }
            grid[r][c] = '0';
            dfs(grid,r-1,c); //top
            dfs(grid,r+1,c);//down
            dfs(grid,r,c-1);//left
            dfs(grid,r,c+1);//right
        }
}
