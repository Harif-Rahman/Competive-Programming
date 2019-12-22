public class ReverseInteger7 {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483412));
    }
    public static int reverse(int x) {
        //2321 >> 2321 / 1000 and 2321-x=2321-232
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) //check for overflow
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
}