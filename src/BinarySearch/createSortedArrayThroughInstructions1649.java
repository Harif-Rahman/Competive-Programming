package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class createSortedArrayThroughInstructions1649 {
    public static void main(String[] args) {
        int[] insttructions = {33,107,17,14,53,61,78,64,59,16,109,30,40,20,13,32,36,83,82,110,68,5,10,96,27,11,60,25,63,93,88,34,101,49,42,23,52,43,79,103,3,41,46,89,19,108,54,98,99,26,80,11,65,2,104,28,105,66,47,71,31,55,90,95,8,21,48,50,87,39,97,56,24,6,92,4,62,67,100,44,22,73,85,111,45,15,74,51,81,69,58,57,102,7,18,76,12,106,37,70,35,38,86,94,9,72,91,84,29,77,75,1};
        createSortedArray(insttructions);
    }

    /**
     * not working
     * @param instructions
     * @return
     */
    public static int createSortedArray(int[] instructions) {
        List<Integer> ls = new ArrayList<>();
        Map<Integer,Integer> countMap = new HashMap<>();
        int cost = 0;

        for(int i=0;i<instructions.length;i++){
            int findPosition = bS(ls,instructions[i]);
            countMap.put(instructions[i],countMap.getOrDefault(instructions[i],0)+1);

            if(countMap.get(instructions[i]) == 1){
                if(findPosition == ls.size()){
                    ls.add(instructions[i]);
                }else{
                    ls.add(findPosition,instructions[i]);
                }
                cost += Math.min(findPosition,ls.size()-findPosition-1);
            }else{
                int ind = findPosition-1;
                int leftSize = 0;
                while(ind > -1){
                    leftSize+= countMap.get(ls.get(ind));
                    ind--;
                }
                ind = findPosition + 1;
                int rightSize = 0;
                while(ind < ls.size()){
                    rightSize += countMap.get(ls.get(ind));
                    ind++;
                }
                cost += Math.min(leftSize,rightSize);
            }

        }
        return cost;
    }
    private static int bS(List<Integer> ls,int target){
        int low = 0;
        int high = ls.size()-1;

        while(low < high){
            int mid = low + (high-low)/2;
            if(ls.get(mid) < target){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        // handle for last element only
        return (low == ls.size()-1 && target > ls.get(ls.size()-1)) ? ls.size() : low;
    }
}
