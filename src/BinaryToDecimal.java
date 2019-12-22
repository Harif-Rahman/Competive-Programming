public class BinaryToDecimal {
    public static void main(String[] args) {
        System.out.println(binaryToInt(1111));
    }
    private static int binaryToInt(int binary){
        int result = 0;
        int n=0;
        while (binary != 0){
            result += (binary % 10) * Math.pow(2,n++);
            binary/=10;
        }
        return result;
    }
}
