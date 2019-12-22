public class RotateFunction39 {
    public static void main(String[] args) {
        int[] arr = {1000000007};
        System.out.println(maxRotateFunction(arr));
    }
    public static int maxRotateFunction(int[] A) {
        int max =A[0];
        int maxInd =-1;
        for(int i=1;i<A.length;i++){
            if(A[i] > max){
                max = A[i];
                maxInd=i;
            }
        }
        if(maxInd == -1 && A.length != 1)
            return A[0];
        int prevProd=-1;
        int currentProd=0;
        while(prevProd < currentProd){
            prevProd = currentProd;
            currentProd = 0;
            int p=0;
            for(int i=(maxInd + 1) % A.length;p<A.length && i < A.length;){
                currentProd  += A[i]*p++;
                i=(i+1)%A.length;
            }
            maxInd =(maxInd + 1) % A.length;
        }
        return prevProd;
    }
}
