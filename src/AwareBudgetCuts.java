import java.util.Arrays;

public class AwareBudgetCuts {

    static double findGrantsCap(double[] grantsArray, double newBudget) {
        // your code goes here
        Arrays.sort(grantsArray);
        // 2,  50, 100,120, 1000
        //       |   |
        double cap = 0;
        for(int i=0;i<grantsArray.length;i++){
            double avgAmount = newBudget / (grantsArray.length - i); //190/5 = 38
            cap = Math.max(avgAmount,cap);
            if(avgAmount < grantsArray[i]){
                // asking for higher budget
                System.out.println("assigning "+avgAmount);
                newBudget -= avgAmount;
            }else{
                newBudget -= grantsArray[i];
                System.out.println("assigning "+grantsArray[i]);
            }
        }
        return cap;
    }

    public static void main(String[] args) {
        double[] arr = {2, 100, 50, 120, 1000};
        double newBudget = 190;
        System.out.println(findGrantsCap(arr,newBudget));
    }
}
