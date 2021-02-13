package Trie;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LongestWordInDictionary720 {
    public static void main(String[] args) {
        String[] strArr = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(longestWordBFS(strArr));
    }
    String res = "";

    /**
     * DFS
     * TC : TOTAL WORDS LENGTH * MAX WORD LENGTH + 26 * TOTAL WORDS LENGTH
     * @param words
     * @return
     */
    public String longestWordDFS(String[] words) {
        Trie root = new Trie();
        for(String str : words){
            addWord(str,root);
        }

        getLongestWordDFS(root,"");
        return res;
    }

    private void getLongestWordDFS(Trie curr,String str){
        for(int i=0;i<26;i++){
            if(curr.children[i] != null && curr.children[i].isWord){
                char c = (char)(i + (int)'a');
                getLongestWordDFS(curr.children[i],str+c);
            }
        }
        if(res.length() < str.length()){
            res = str;
        }
    }
    /**
     *
     *bfs
     * WORKING
     * @param words
     * @return
     */
    public static String longestWordBFS(String[] words) {
        Trie root = new Trie();
        for(String str : words){
            addWord(str,root);
        }
        String res = "";
        Queue<Pair<String,Trie>> queue = new LinkedList<>();
        queue.add(new Pair("",root));

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair<String,Trie> pop = queue.remove();
                String str = pop.getKey();
                if(str.length() > res.length()){
                    res = str;
                }
                Trie curr = pop.getValue();;
                for(int j=0;j<26;j++){
                    if(curr.children[j] != null && curr.children[j].isWord){
                        char c = (char)((int)'a' + j);
                        queue.add(new Pair<>(str + c,curr.children[j]));
                    }
                }
            }
        }
        return res;
    }
    private static void addWord(String word,Trie root){
        Trie curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new Trie();
            }
            curr = curr.children[c-'a'];
        }
        curr.isWord = true;
    }


    static class Trie{
        boolean isWord;
        Trie[] children;
        Trie(){
            children = new Trie[26];
        }
    }
}
