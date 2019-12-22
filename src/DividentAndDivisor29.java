import java.util.Map;

public class DividentAndDivisor29 {
    public static void main(String[] args) {
        int divident = 25;
        int divisor = 3;
        System.out.println(divide(divident,divisor));
    }
    /*
    integer out of flow exception
     */
    private static int getQuotient(int divident,int divisor){
        if(divident < divisor) return -1;
        int sign = (divident * divisor > 0 ? 1 : -1);
        divident = Math.abs(divident);
        divisor = Math.abs(divisor);
        int quotient =0;
        while (divident >= divisor){
            divident-=divisor;
            quotient++;
        }
        return quotient * sign;

    }
    public static int divide(int dividend, int divisor) {
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? true : false;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long result = 0;
        while(absDividend >= absDivisor){
            long tmp = absDivisor, count = 1;
            while(tmp <= absDividend){
                tmp <<= 1;
                count <<= 1;
            }
            result += count >> 1;
            absDividend -= tmp >> 1;
        }
        return  isNegative ? (int) ~result + 1 : result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }
}
