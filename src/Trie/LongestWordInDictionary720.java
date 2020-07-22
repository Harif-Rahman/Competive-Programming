package Trie;

import java.util.Arrays;

public class LongestWordInDictionary720 {
    static Trie root = null;
    public static void main(String[] args) {
        root = new Trie();
        String[] strArr = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        Arrays.sort(strArr);
        for (String str : strArr){
            buildWordFromAnotherWord(str);
        }
    }
    private static void buildWordFromAnotherWord(String str){
        Trie curr = root;
        for(int i=0;i<str.length() && curr != null;i++){
            char c = str.charAt(i);
            if(i == 0){
                curr.child[c-'a'] = new Trie();
                curr.ch = c;
            }
            curr = curr.child[c-'a'];
        }
    }
    static class Trie{
        Character ch = null;
        boolean isWord;
        Trie[] child = new Trie[26];
    }
}
