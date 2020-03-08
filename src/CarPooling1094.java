import java.util.Arrays;
public class CarPooling1094 {
    public static void main(String[] args) {
        int[][] arr = {{3,2,7},{3,7,9},{8,3,9}};
        int totCapacity = 11;
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o2[1],o1[1]));
        int[] tempArr = arr[0];
        int currentCapacity = tempArr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i][1] < tempArr[1]){
                // lies betwwen the interval
                int capacity = arr[i][0];
                if(currentCapacity + capacity > totCapacity){
                    System.out.println(false);
                }
                else{
                    currentCapacity += capacity;
                }
            }else{
                // doesn't lie in this interval
                tempArr = arr[i];
            }
        }
    }
}
/*

2  1 5    capacity 4
3  3 7


2  1 5     capacity 5
3  3 7

2  1 5     capacity 3
3  5 7

3  2 7     capacity 11
8  3 9
3  7 9

*/