import static java.lang.Math.abs;

public class FindSqaureRootOfNumber {
    public static void main(String[] args) {
        System.out.println(sqrt(26));
    }
    private static double sqrt(double val){
        double start = 0;
        double end = val;
        double prevMid = 0;
        while (start < end){
            double mid = (start + end)/2;
            if(mid * mid == val || abs(mid-prevMid) < 0.0005){
                return mid;
            }
            if(mid * mid < val){
                start = mid;
            }else{
                end = mid;
            }
            prevMid = mid;
        }
        return 0;
    }
}

