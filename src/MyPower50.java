public class MyPower50 {
    public static void main(String[] args) {
        System.out.println(myPow(2,5));
    }
    public static double myPow(double x, int n) {
        System.out.println("x--->"+x+" --->"+n);
        if(n == 0){
            return 1;
        }
        if(n<0){
            n = -n; //2 ^ -3 == (1/2) ^ 3
            x = 1/x;
        }

        return n % 2 == 0 ? myPow(x*x,n/2) : x * myPow(x*x,n/2);
    }
}
