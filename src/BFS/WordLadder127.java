package BFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder127 {
    /*
    Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
     */
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        System.out.println(ladderLength("hit","cog",wordList));

    }

    /**
     * TC : O ( QUEUE SIZE * WORD LENGTH ^ 2 * 26) // IGNORE 26
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);
        queue.add(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int p = 0;p<size;p++){
                String poppedStr = queue.remove();
                if(poppedStr.equals(endWord)){
                    return level;
                }
                StringBuilder sb = new StringBuilder(poppedStr); // TAKES LENGTH OF WORD TIME
                for(int i=0;i<poppedStr.length();i++){
                    char prev = poppedStr.charAt(i);
                    for(char c = 'a';c <='z';c++){
                        if(c != prev){
                            sb.setCharAt(i,c);
                            String res = sb.toString();
                            if(set.contains(res)){
                                queue.add(res);
                                set.remove(res);
                            }
                        }
                    }
                    sb.setCharAt(i,prev);
                }
            }
            level++;
        }
        return -1;
    }
}
