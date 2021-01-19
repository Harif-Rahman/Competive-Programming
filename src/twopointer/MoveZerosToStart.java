package twopointer;

public class MoveZerosToStart {
    public static void main(String[] args) {
        int[] arr = new int[]{1,0,0,1,1,0,0,1,0,1};
        moveZerosToStart(arr);
        System.out.println(arr);
    }
    private static void moveZerosToStart(int[] arr){
        int i=0;

        for(int j=0;j<arr.length;j++){
            if(arr[j] == 0){
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            if(arr[i] == 0){
                i++;
            }
        }
    }
}
