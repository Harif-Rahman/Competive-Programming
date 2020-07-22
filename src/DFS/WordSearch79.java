package DFS;

public class WordSearch79 {
    public static void main(String[] args) {
        char[][] baord = {

                {'a'}
        };
/*        char[][] board =
                {
                        {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}
                };*/
        System.out.println(exist(baord, "a"));
    }
    static boolean match = false;

    /**
     *  TC : M * N * 4 ^ LENGTH OF WORD
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(match){
                    return true;
                }else{
                    dfs(board,visited,0,word,i,j);
                }
            }
        }
        return match;
    }
    private static void dfs(char[][] board,boolean[][] visited,int pos,String str,int i,int j){
        /**
         * important to have this test case first
         */
        if(pos == str.length()){
            match = true; //if we reach. end means we got the match
            return;
        }
        if(match){
            return;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            return;
        }
        if(visited[i][j]){
            return;
        }

        if(str.charAt(pos) != board[i][j]){
            return;
        }
        visited[i][j] = true;
        dfs(board,visited,pos+1,str,i+1,j);//down
        dfs(board,visited,pos+1,str,i-1,j);//top
        dfs(board,visited,pos+1,str,i,j+1);//right
        dfs(board,visited,pos+1,str,i,j-1);//left

        visited[i][j] = false;//backtrack
    }
}
