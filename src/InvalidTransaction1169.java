import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvalidTransaction1169 {
    public static void main(String[] args) {
        String[] str = {"alice,20,800,mtv","alice,50,100,beijing"};
        invalidTransactions(str);
    }
    public static List<String> invalidTransactions(String[] transactions) {
        final int maximumAmount = 1000; // 1000 dollars
        final int timeLimitForAnotherTransactionInAnotherCity = 60;// 60 minutes
        List<String> ls = new ArrayList<>();
        Map<String,Map<String,Integer>> hm = new HashMap<>();
        Map<String,String> lastTransactionMap = new HashMap<>();
        for(String transaction : transactions){
            String[] str = transaction.split(",");
            int money = Integer.parseInt(str[2]);
            if(money > maximumAmount){
                ls.add(transaction);
                continue;
            }
            String name = str[0];
            Integer currentTime = Integer.parseInt(str[1]);
            String city = str[3];
            if(hm.get(name) == null){
                Map<String,Integer> lastWithDrawalTimeByCityMap = new HashMap<>(1);
                lastWithDrawalTimeByCityMap.put(city,currentTime);
                hm.put(name,lastWithDrawalTimeByCityMap);
                lastTransactionMap.put(name,city);
            }else{
                // if person has made the last transaction in the same city
                String lastTransactionCity = lastTransactionMap.get(name);
                if(lastTransactionCity.equals(city)){
                    hm.get(name).put(city,currentTime);
                    lastTransactionMap.put(name,city);
                }else{
                    // if person hasn't made the last transaction in the current city or different city within 60 minutes
                    Map<String,Integer> lastWithDrawalTimeByCityMap = hm.get(name);
                    Integer lastWithdrawalTime = lastWithDrawalTimeByCityMap.get(lastTransactionCity);

                    if(currentTime - lastWithdrawalTime < timeLimitForAnotherTransactionInAnotherCity){
                        hm.get(name).put(city,currentTime);
                        lastTransactionMap.put(name,city);
                    }else{
                        ls.add(transaction);
                    }
                }
            }
        }
        return ls;
    }
}
