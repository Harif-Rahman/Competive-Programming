package Array;

public class SumOfArrayWithoutLoops {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,10};
        System.out.println(calculateSum(arr, 0, 0));

    }
    private static int calculateSum(int[] arr,int index,int sum){
        if(index == arr.length){
            return 0;
        }
        return arr[index] + calculateSum(arr,index+1,sum);
    }
}
