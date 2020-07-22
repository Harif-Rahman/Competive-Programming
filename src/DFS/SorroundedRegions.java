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
    public static void solve(char[][] board) {
        int rlen = board.length;
        int clen = board[0].length;
        boolean[][] visited = new boolean[rlen][clen];
        for(int i=0;i<rlen;i++){
            for(int j=0;j<clen;j++){
                if(board[i][j] == 'O'){
                    isSurrounded(board,i,j,visited);
                    System.out.println(board);
                }
            }
        }
    }
    private static boolean isSurrounded(char[][] board,int r,int c,boolean[][] visited){
        System.out.println("row -->"+r+" col --->"+c);
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c]){
            return false;
        }
        if(board[r][c] == 'X'){
            return true;
        }
        visited[r][c] = true;

        boolean top = isSurrounded(board,r-1,c,visited);
        boolean bottom = isSurrounded(board,r+1,c,visited);
        boolean left = isSurrounded(board,r,c-1,visited);
        boolean right = isSurrounded(board,r,c+1,visited);
        if( left && right && top && bottom){
            board[r][c] = 'X';
            return true;
        }
        return false;
    }
}
