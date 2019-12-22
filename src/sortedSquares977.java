public class sortedSquares977 {
    /*
    Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.



Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
     */
    public static void main(String[] args) {
        sortedSquares1(new int[]{-3, -2, -1, 2, 3, 4, 5});
    }
    /*
    having a pointer between the negativa element start and positve adn
     */
    public static int[] sortedSquares(int[] A) {
        int posPointer = 0;
        // set the positive index to starting the positive element
        while (posPointer < A.length && A[posPointer] < 0) {
            posPointer++;
        }
        // set the negative index before positive index
         int negPointer = posPointer - 1;
        int[] arr = new int[A.length];
        int counter = 0;
        while (negPointer >= 0 && posPointer < A.length) {
            int negSquares = A[negPointer] * A[negPointer];
            int posSquares = A[posPointer] * A[posPointer];
            // [-5, -3, -2, 1,  2]
            //          n   p
            if (negSquares > posSquares) {
                arr[counter++] = posSquares;
                posPointer++;
            } else {
                arr[counter++] = negSquares;
                negPointer--;
            }
        }
        // here we might ended up missing the elemets at the start or end we need to set to arr
        while (negPointer >= 0) {
            arr[counter] = A[negPointer] * A[negPointer];
            negPointer--;
            counter++;
        }
        while (posPointer < A.length) {
            arr[counter] = A[posPointer] * A[posPointer];
            posPointer++;
            counter++;
        }
        return arr;
    }

/*
TOO GOOD:
having a pointer to start and end comparing the value with abs values setting the biggest value sqaure at the end of the new array;
 */

    public static int[] sortedSquares1(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }

}
