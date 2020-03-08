public class ReverseStringNo541 {
    /*

    Given a string and an integer k, you need to reverse the first k characters for
     every 2k characters counting from the start of the string. If there are less than k characters left,
     reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
    Example:
    Input: s = "abcdefg", k = 2
    Output: "bacdfeg"
     */
    public static void main(String[] args) {
        String str = "abcdefghijk";
        System.out.println(reverse2(str, 3));
    }

    private static StringBuilder sb = new StringBuilder();


    public static String reverse1(String s, int k) {

        for (int i = 0; i < s.length(); i += 2 * k) {
            int adj = i + k > s.length() ? s.length() : i + k;
            sb.append(reverseStr(s.substring(i, adj)));
            sb.append(s.substring(adj, i + 2 * k > s.length() ? s.length() : i + 2 * k));
        }
        return sb.toString();
    }
    private boolean isVowel(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    private static String reverseStr(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    public static String reverse2(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while(i < n) {
            int j = Math.min(i + k - 1, n - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }
    private static void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}
