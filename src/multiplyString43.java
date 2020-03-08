import java.math.BigInteger;

public class multiplyString43 {
    /*
    43. Multiply Strings
Medium

1359

629

Add to List

Share
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
     */
    public static void main(String[] args) {

        System.out.println(multiply1("-123", "456"));
    }

    /**130 ms 10 % FASTER
     * WORST
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        BigInteger gmul = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;
        boolean negSign1 = true;
        boolean negSign2 = true;
        if(num1.length() < num2.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        if(num1.charAt(0) == '-'){
            negSign1 = false;
            num1 = num1.substring(1);
        }
        if(num2.charAt(0) == '-'){
            negSign2 = false;
            num2 = num2.substring(1);
        }
        for (int i = num2.length() - 1; i > -1; i--) {
            int digit = num2.charAt(i) - '0';
            BigInteger mul = BigInteger.ONE;
            BigInteger res = BigInteger.ZERO;
            BigInteger div = BigInteger.TEN;
            BigInteger carr = BigInteger.ZERO;
            for (int j = num1.length() - 1; j > -1; j--) {
                res = res.add(BigInteger.valueOf((num1.charAt(j) - '0') * digit).add(carr).multiply(mul));
                if (j != 0) {
                    carr = res.divide(div);
                    res =res.mod(div);
                    div =div.multiply(BigInteger.TEN);
                    mul =mul.multiply(BigInteger.TEN);
                }
            }
            sum = sum.add(res.multiply(gmul));
            gmul =gmul.multiply(BigInteger.TEN);
        }
        return negSign1 && negSign2 || !negSign1 && !negSign2 ? "" + sum : "-" + sum;
    }
    public static String multiply1(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
            return "0";

        int[] ans = new int[num1.length() + num2.length() - 1];

        for (int i = 0; i < num1.length(); i++) {
            int digit = (num1.charAt(i) - '0');
            for (int j = 0; j < num2.length(); j++) {
                ans[i + j] +=  digit * (num2.charAt(j) - '0');
            }
        }

        for (int i = ans.length - 1; i > 0; i--) {
            ans[i - 1] += ans[i] / 10;
            ans[i] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i);
        }

        return sb.toString();
    }

}
