package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/*
Given An array of positive integer find the leader in the array .
An element in the array is Leader is the number  if it is greater than equal to all the number in the right side
eg: [16,17,4,3,5,2]

17,5,2 are the leaders in the array



2
5
17
 */
public class LeadersInArray {

    public static void main(String[] args) {
        int[] arr = {16,17,4,3,5,2};
        List<Integer> ls = getLeaders(arr);
        System.out.println(ls);
    }
    private static List<Integer> getLeaders(int[] arr){
        List<Integer> ls = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i=arr.length-1;i >=0;i--){
           if(max < arr[i]){
               ls.add(arr[i]);
               max = arr[i];
           }
        }
        return ls;
    }

    private static List<Integer> getLeadersWithStack(int[] arr){
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<arr.length;i++){
            while (!stack.isEmpty() && stack.peek() < arr[i]){
                stack.pop();
            }
            stack.push(arr[i]);
        }
        return stack.stream().collect(Collectors.toList());
    }
}
