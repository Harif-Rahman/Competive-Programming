public class NthDigit400 {
    public static void main(String[] args) {
        for(int i=10;i<30;i++)
        System.out.println(findNthDigit1(i));
    }
    public static int findNthDigit(int n) {
        int count =1;
        int totcount =1;
        while(count<=n){
            int i = count;
            int div = (int)Math.pow(10,getSizeOfInteger(count)-1);
            int temp = count;
            while(div > 0){
                i = temp / div;
                if(totcount == n)
                    return i % 10;
                div/=10;
                totcount++;
            }
            count++;
        }
        return 0;
    }
    public static int findNthDigit1(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
    private static int getSizeOfInteger(int n){
        return (int) Math.log10(n) + 1;
    }
}
  /*
    1
    2
    3
    4
    5
    6
    7
    8
    9
    1 10
    0 11
    1 12
    1 13
    1 14
    2 15
    1 16
    3 17
    1 18
    4 19
    1 20
    5 21
    1 22
    6 23
    1 24
    7 25
    1 26
    8 27
    1 28
    9 29
    2 30
    0
    2
    1
    2
    2
    */
