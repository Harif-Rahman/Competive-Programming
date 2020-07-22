import java.util.ArrayList;
import java.util.List;

public class FindMissingAndRepeatedNumber {
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        ls.add(3);
        ls.add(1);
        ls.add(2);
        ls.add(5);
        ls.add(3);
        repeatedNumber(ls);
    }
    public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        List<Integer> clone = new ArrayList<>(A);
        int p =0;
        int sum =0;
        for(int i=0;i<clone.size();i++){
            sum += A.get(i);
            if(clone.get(Math.abs(clone.get(i))-1) < 0){
                p = Math.abs(clone.get(i));
                break;
            }else{
                clone.set(Math.abs(clone.get(i))-1,-1 * clone.get(Math.abs(clone.get(i))-1));
            }
        }
        int totSum = A.size() * (A.size() +1)/2;

        ArrayList<Integer> res = new ArrayList<>(2);
        res.add(p);
        res.add(totSum - sum + p);
        return res;
    }
}
