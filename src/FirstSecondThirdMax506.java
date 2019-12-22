public class FirstSecondThirdMax506 {
    /*
    506. Relative Ranks
    Easy

    209

    436

    Favorite

    Share
    Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

    Example 1:
    Input: [5, 4, 3, 2, 1]
    Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
    Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
    For the left two athletes, you just need to output their relative ranks according to their scores.
    Note:
    N is a positive integer and won't exceed 10,000.
    All the scores of athletes are guaranteed to be unique.
     */
    public static void main(String[] args) {
        System.out.println(findRelativeRanks(new int[]{10,3,8,9,4}));
    }

    public static String[] findRelativeRanks(int[] nums) {
        int firstMaxVal = Integer.MIN_VALUE;
        int secMaxVal = Integer.MIN_VALUE;
        int thirdMaxVal = Integer.MIN_VALUE;

        int firstMexInd = 0;
        int secondMaxInd = 0;
        int thirdMaxInd = 0;
        int[] pos = new int[nums.length];
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstMaxVal) {
                thirdMaxVal = secMaxVal;
                thirdMaxInd = secondMaxInd;

                secMaxVal = firstMaxVal;
                secondMaxInd = firstMexInd;

                firstMaxVal = nums[i];
                pos[i] =1;
            } else {
                if (nums[i] > secMaxVal) {
                    thirdMaxVal = secMaxVal;
                    thirdMaxInd = secondMaxInd;
                    if(secondMaxInd!= 0)
                    pos[secondMaxInd]++;

                    secMaxVal = nums[i];
                    secondMaxInd =i;
                    pos[i] = 2;
                } else {
                    if (nums[i] > thirdMaxVal) {
                        pos[thirdMaxInd]+=1;
                        thirdMaxVal = nums[i];
                        thirdMaxInd = i;
                        pos[i] = 3;
                    }else{
                        pos[i]=i+1;
                    }
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == firstMaxVal) {
                arr[i] = "Gold Medal";
            } else {
                if (nums[i] == secMaxVal) {
                    arr[i] = "Silver Medal";
                } else {
                    if (nums[i] == thirdMaxVal) {
                        arr[i] = "Bronze Medal";
                    } else {
                        arr[i] = String.valueOf(i+1);
                    }
                }
            }

        }
        return arr;
    }
}

