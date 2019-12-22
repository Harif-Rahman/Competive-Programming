public class Main {

    static int getDifferentNumber(int[] arr) {
        // your code goes here
        int[] arr1 = new int[getMax(arr)+1];
        for(int i : arr){
            arr1[i]++;
        }
        // arr[4]=1,arr[7]=1,arr[8]=1,arr[9]=1
        for(int i=0;i<arr1.length;i++){
            if(arr1[i] == 0)
                return i;
        }
        return arr1.length;
    }

    public static void main(String[] args) {
        System.out.println(getDifferentNumber(new int[]{0,1,2,4}));
    }
    static int getMax(int[] arr){
        int max =arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
