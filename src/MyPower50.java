public class MyPower50 {
    public static void main(String[] args) {
        System.out.println(myPow(2,10));
    }
    public static double myPow(double x, int n) {
        if(n == 0){
            return 1.0;
        }
        if(n == 1){
            return x;
        }

        if(n % 2 == 0){
            return myPow(x,n/2)*myPow(x,n/2);
        }else{
            return x * myPow(x,n-1);
        }
    }
}
