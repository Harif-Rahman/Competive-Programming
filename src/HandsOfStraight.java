import java.util.Arrays;
import java.util.Comparator;

public class HandsOfStraight {
    public static void main(String[] args) {
        Integer[] arr ={1,3,2,5,9,10,8,6,7};
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o2-o1 == 1)
                    return -1;
                return 1;
            }
        });
        System.out.println(arr);
    }
}
