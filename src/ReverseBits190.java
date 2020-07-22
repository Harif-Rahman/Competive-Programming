public class ReverseBits190 {
    public static void main(String[] args) {
        int n = 43261596;//00000010100101000001111010011100
        reverseBits(n);
    }
    public static int reverseBits(int n) {
        int res = 0;

        while(n > 0){
            int lastDigit = n % 2;
            res += lastDigit;
            n = n >> 1;
            res <<= 1;
        }
        return res/2;
    }
}
