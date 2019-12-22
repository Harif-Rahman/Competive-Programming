public class missingNumber268 {
    /*
    Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
     */
    public static void main(String[] args) {
        int[] arr = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber1(arr));
    }
    //Approach: Gauss' Formula [Accepted] sum(i=0:n) = n*(n+1)/2;
    private static int missingNumber(int[] arr){
        int sum =0;
        int totSum = arr.length*(arr.length+1)/2;
        for (int i : arr) {
            sum+=i;
        }
        return totSum-sum;
    }
    /*
    The actual list contains integers from 0 to n, the list we are given has 1 missing element.
So we can conclude n = length of the given list
What you need to know about XOR is that it's both commutive and assosiative
commutive means A ^ B = B ^ A
assosiative means (A ^ B) ^ C = A ^ (B ^ C)
This means that order doesn't matter
Other thing you need to know about XOR, if you XOR 2 similar numbers, the result is 0. A ^A = 0
So now we will XOR the value of n with all the indicies from 0 to n-1 and with all the values we have in our array.
For example:
array = 0,1,2,4
index = 0,1,2,3
n = 4
4 ^ (0^0) ^ (11) ^ (2^2) ^ (4^3)
= (4^4) ^ (0^0) ^ (11) ^ (2^2) ^ 3
= 0 ^ 0 ^ 0 ^ 0 ^ 3
= 3
     */


    private static int missingNumber1(int[] arr){
        int res=arr.length;
        for(int i=0;i<arr.length;i++){
            res^=i^arr[i];
        }
        return res;
    }




}
