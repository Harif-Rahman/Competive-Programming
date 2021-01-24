package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SearchSuggestionSystem128 {
    public static void main(String[] args) {
        String[] arr = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        suggestedProducts(arr,searchWord);
    }
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        Arrays.sort(products); // for lexicographical
        List<String> productsList = Arrays.asList(products);

        for (int i = 0; i < products.length; i++) {
            map.put(products[i], i);
        }
        char maxTimePressedKey = '\0';

        String key = "";
        for (char c : searchWord.toCharArray()) {
            key += c;
            String ceiling = map.ceilingKey(key);
            String floor = map.floorKey(key + "~"); // used tilde we can use any character 'z'
            if (ceiling == null || floor == null) break;
            // get next 3 strings within floor string min used because we dont need string after floor
            res.add(productsList.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
        }

        while (res.size() < searchWord.length()) res.add(new ArrayList<>());
        return res;
    }
}
