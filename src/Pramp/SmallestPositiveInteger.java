package Pramp;

import java.util.Arrays;

public class SmallestPositiveInteger {
    static int getDifferentNumber(int[] arr) {
        System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
            while(arr[i] >= 0 && arr[i] < arr.length && arr[i] != arr[arr[i]]){
                int temp = arr[i];
                arr[i] = arr[arr[i]];
                arr[arr[i]] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
            if(arr[i] != i){
                return i;
            }
        }
        return arr.length;
    }

    public static void main(String[] args) {
        System.out.println(getDifferentNumber(new int[]{1,3,0,2}));
    }
}
