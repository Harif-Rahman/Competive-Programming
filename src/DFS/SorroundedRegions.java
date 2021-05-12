package DFS;

public class SorroundedRegions {
    /*
    Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
     */
    public static void main(String[] args) {
        char[][] board = {
                {'O', 'O', 'O' ,'O','X','X'},
                {'O', 'O', 'O' ,'O','O','O'},
                {'O', 'X', 'O' ,'X','O','O'},
                {'O', 'X', 'O' ,'O','X','O'},
                {'O', 'X', 'O' ,'X','O','O'},
                {'O', 'X', 'O' ,'O','O','O'},
        };
        solve(board);

        System.out.println(board);
    }

    /**
     *
     * intuition is check only the boundary because only boundary cell will not be sorrounded by X
     * WORKING
     * TC : M - ROWS N - COL - M*N TC
     * @param board
     */
    public static void solve(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
       // row will be constant col will change
        for(int i=0;i<board[0].length;i++){
            dfs(board,0,i);
        }
        // row will be constant col will change
        for(int i=0;i<board[0].length;i++){
            dfs(board,board.length-1,i);
        }
        // col willl be constant
        for(int i=0;i<board.length;i++){
            dfs(board,i,0);
        }
        for(int i=0;i<board.length;i++){
            dfs(board,i,board[0].length-1);
        }
        for(int i=0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                // check only boundaries
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'M'){
                    board[i][j] = 'O';
                }
            }
        }

    }
    private static void dfs(char[][] board,int i,int j){
        System.out.println("row -> "+i + "col ->"+j);
   /*     if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return;
        }
        if(board[i][j] == 'M' || board[i][j] == 'X'){
            return;
        }
        board[i][j] = 'M';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);*/
    }
}
