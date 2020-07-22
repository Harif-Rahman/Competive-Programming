import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverse1424 {
    public static void main(String[] args) {
    }
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<nums.size();i++){
            int row = i;
            int col = 0;
            while(row >= 0){
                if(col < nums.get(row).size()){
                    ls.add(nums.get(row).get(col));
                }
                col++;
                row--;
            }
        }
            /*

    */
        int colg = 1;
        for(int rowg = nums.size()-1;rowg > -1 ;rowg--){
            for(int i=colg;i < nums.get(rowg).size()-1;i++){
                int row = rowg;
                int col = i;
                while(row >= 0){
                    if(col < nums.get(row).size()){
                        ls.add(nums.get(row).get(col));
                    }
                    col++;
                    row--;
                }
            }
            colg += 2;
            rowg--;
        }
        int[] res = new int[ls.size()];
        for(int i=0;i<ls.size();i++){
            res[i] = ls.get(i);
        }
        return res;
    }
}
