package backtracking;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver37 {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
            };

        solveSudoku(board);
        };

    public static void solveSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] != '.'){
                    String rowStr = i + "-row-" + board[i][j];
                    String colStr = j + "-col-" + board[i][j];
                    String boxStr = i/3 +"box ->"+ j/3 + "->val->" + board[i][j];
                    set.add(rowStr);
                    set.add(colStr);
                    set.add(boxStr);
                }
            }
        }
        solve(board,set);
    }
    private static boolean solve(char[][] board,Set<String> set){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == '.'){
                    for(char c = '1';c <= '9';c++){
                        if(isValidSudoku(i,j,c,set)){
                            board[i][j] = c; // trial and error
                            if(solve(board,set)){
                                return true;
                            }else{
                                board[i][j] = '.';
                                String rowStr = i + "-row-" + c;
                                set.remove(rowStr);
                                String colStr = j + "-col-" + c;
                                set.remove(colStr);
                                String boxStr = i/3 +"box ->"+ j/3 + "->val->" + c;
                                set.remove(boxStr);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValidSudoku(int i, int j, char c, Set<String> set) {
        String rowStr = i + "-row-" + c;
        String colStr = j + "-col-" + c;
        String boxStr = i/3 +"box ->"+ j/3 + "->val->" + c;
        if(set.contains(rowStr)){
            return false;
        }
        if(set.contains(colStr)){
            return false;
        }
        if(set.contains(boxStr)){
            return false;
        }
        set.add(rowStr);
        set.add(colStr);
        set.add(boxStr);
        return true;
    }
}
