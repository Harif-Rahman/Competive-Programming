import java.util.ArrayList;
import java.util.List;

public class NQueensProblem {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int n = 4;
        solveNQueen(n,0,new ArrayList<>(),result);
        System.out.println(result);
    }
    private static void solveNQueen(int n,int row,List<Integer> colPlacements,List<List<Integer>> result){
        if(n == row){
            result.add(new ArrayList<>(colPlacements));
        }else{
            for(int i=0;i < n;i++){
                colPlacements.add(i);
                if(isValid(colPlacements)){
                    solveNQueen(n,row+1,colPlacements,result);
                }
                colPlacements.remove(colPlacements.size()-1); // back track
            }
        }
    }
    private static boolean isValid(List<Integer> colPlacements){
        int n = colPlacements.size()-1;
        int currRow = colPlacements.size()-1;
        int currCol = colPlacements.get(currRow);
        for(int i=0;i<n;i++){
            int colDistance = Math.abs(colPlacements.get(i)- currCol);
            int rowDistance = currRow-i;
            /*
            ________________
            | .//invalid
            |   .
            |
            |
               ________________
            | .//invalid
            | .
            |
            |

            if col  distance is 0 or row distance equals col distance then they are diagonal or same column
             */
            if(colDistance == 0 || colDistance == rowDistance){
                return false;
            }
        }
        return true;
    }
}
