public class FriendRequest825 {
    public static void main(String[] args) {
        int[] arr = {20,30,100,110,120};
        System.out.println(numFriendRequests(arr));
    }
    public static int numFriendRequests(int[] ages) { int res = 0;
        int[] numInAge = new int[121], sumInAge = new int[121];

        for(int i : ages)
            numInAge[i] ++;

        for(int i = 1; i <= 120; ++i)
            sumInAge[i] = numInAge[i] + sumInAge[i - 1];

        for(int i = 15; i <= 120; ++i) {
            if(numInAge[i] == 0) continue;
            int count = sumInAge[i] - sumInAge[i / 2 + 7];
            res += count * numInAge[i] - numInAge[i]; //people will not friend request themselves, so  - numInAge[i]
        }
        return res;

    }
}
