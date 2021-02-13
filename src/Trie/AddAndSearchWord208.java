package Trie;
/*
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 */
public class AddAndSearchWord208 {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
        System.out.println(wordDictionary.search("...."));
    }


    static class WordDictionary {
        Trie root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new Trie();
        }

        public void addWord(String word) {
            Trie curr = root;
            for(char c : word.toCharArray()){
                if(curr.children[c-'a'] == null){
                    curr.children[c-'a'] = new Trie();
                }
                curr = curr.children[c-'a'];
            }
            curr.isEnd = true; // mark it as word
        }

        public boolean search(String word) {
            return dfs(word,root,0);
        }

        private boolean dfs(String word,Trie curr,int ind){
            if(ind == word.length()){
                return curr.isEnd;
            }
            char c =  word.charAt(ind);

            if(c != '.'){
                return curr.children[c-'a'] != null && dfs(word,curr.children[c-'a'],ind+1);
            }else{
                boolean isMatch = false;
                for(int p=0;p<26;p++){
                    if(curr.children[p] != null && dfs(word,curr.children[p],ind+1)){
                        isMatch = true;
                        break;
                    }
                }
                return isMatch;
            }
        }

         class Trie{
            boolean isEnd = false;
            Trie[] children = null;

            Trie(){
                children = new Trie[26];
            }
        }
    /*
           root

    [a b c d e f g h i j]
    */
    }

}
