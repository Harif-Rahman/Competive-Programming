package Pramp;
/*
Given an array arr of unique nonnegative integers,
implement a function getDifferentNumber that finds the smallest nonnegative integer that is NOT in the array.
input:  arr = [0, 1, 2, 3]

output: 4
 */
public class GettingDifferentNumber {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(getDifferentNumber(arr));
    }

    /**
     * tc : o(n) sc : o(1)
     *
     * intuition is to fit the element in correct index
     * then we can able to find the number which is missing
     * @param arr
     * @return
     */
    static int getDifferentNumber(int[] arr) {
        for(int i=0;i<arr.length;i++){
            while(arr[i] < arr.length && arr[i] != i){
                int temp = arr[i];
                arr[i] = arr[arr[i]];
                arr[temp] = temp;
            }
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i] != i){
                return i;
            }
        }
        return arr.length;
    }
}
