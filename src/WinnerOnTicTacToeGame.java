public class WinnerOnTicTacToeGame {
    /*
    1275. Find Winner on a Tic Tac Toe Game
Easy

78

35

Add to List

Share
Tic-tac-toe is played by two players A and B on a 3 x 3 grid.

Here are the rules of Tic-Tac-Toe:

Players take turns placing characters into empty squares (" ").
The first player A always places "X" characters, while the second player B always places "O" characters.
"X" and "O" characters are always placed into empty squares, never on filled ones.
The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Given an array moves where each element is another array of size 2 corresponding to the row and column of the grid where they mark their respective character in the order in which A and B play.

Return the winner of the game if it exists (A or B), in case the game ends in a draw return "Draw", if there are still movements to play return "Pending".

You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the grid is initially empty and A will play first.



Example 1:

Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: "A" wins, he always plays first.
"X  "    "X  "    "X  "    "X  "    "X  "
"   " -> "   " -> " X " -> " X " -> " X "
"   "    "O  "    "O  "    "OO "    "OOX"
Example 2:

Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
Output: "B"
Explanation: "B" wins.
"X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
"   " -> " O " -> " O " -> " O " -> "XO " -> "XO "
"   "    "   "    "   "    "   "    "   "    "O  "
Example 3:

Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
Output: "Draw"
Explanation: The game ends in a draw since there are no moves to make.
"XXO"
"OOX"
"XOX"
Example 4:

Input: moves = [[0,0],[1,1]]
Output: "Pending"
Explanation: The game has not finished yet.
"X  "
" O "
"   "
     */

    public static void main(String[] args) {
        int[][] arr = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
        System.out.println(getWinnerrOfTicTacToe(arr));

    }

    private static String getWinnerrOfTicTacToe(int[][] arr) {
        int size = 3;
        int[] row = new int[size];
        int[] col = new int[size];
        int diag = 0;
        int antiDiag = 0;
        boolean player1 = true;
        for (int[] arr1 : arr) {
            int val = player1 ? 1 : -1;
            if (arr1[0] == arr1[1]) {
                diag += val;
            }
            if (arr1[0] + arr1[1] + 1 == size) {
                antiDiag += val;
            }
            row[arr1[0]] += val;
            col[arr1[1]] += val;
            if (Math.abs(row[arr1[0]]) == size||
                    Math.abs(col[arr1[1]]) == size ||
                    Math.abs(diag) == size ||
                    Math.abs(antiDiag) == size
            ){
                return player1 ? "A" : "B";
            }
            player1 = !player1;
        }
        return size * size > arr.length ? "Pending" : "Draw";
    }
}
