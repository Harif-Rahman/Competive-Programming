import java.util.ArrayList;
import java.util.List;

public class CamelCaseMatch1023 {
    public static void main(String[] args) {
        String[] queries = {"FooBarToooP","FooBarTest","FootBall","FrameBuffer","ForceFeedBackPoll"};
        String pattern = "FFBP";
        camelMatch(queries,pattern);
    }

    /**WORKING
     * not done by me
     * good one
     * refere this
     * tc : Q- QUERIES SIZE P - PATTERN LENGTH  O(Q * LENGTH OF MAXIMUM SIZE QUERY )
     * sc : O(QUERIES LENGTH)
     * @param queries
     * @param pattern
     * @return
     */
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();

        char[] patternArr = pattern.toCharArray();
        for (String query : queries) {
            boolean isMatch = match(query.toCharArray(), patternArr);
            res.add(isMatch);
        }

        return res;
    }

    private static boolean match(char[] queryArr, char[] patternArr) {
        int j = 0;
        for (int i = 0; i < queryArr.length; i++) {
            if (j < patternArr.length && queryArr[i] == patternArr[j]) {
                j++;
            } else if (queryArr[i] >= 'A' && queryArr[i] <= 'Z') {
                return false;
            }
        }

        return j == patternArr.length;
    }
}
