package Trie;

public class ImplementTrie208 {
    public static void main(String[] args) {
        Trie Trie = new Trie();
        Trie.insert("apple");
        Trie.insert("harif");
        Trie.insert("rahman");
        System.out.println(Trie.search("apple"));
        System.out.println(Trie.search("harif"));
        System.out.println(Trie.search("harrif"));
        System.out.println(Trie.search("rahman"));
        System.out.println(Trie.startsWith("har"));
    }
    static class Trie {
        class TrieNode{
            boolean end = false;
            TrieNode[] children = null;
            TrieNode(){
                children = new TrieNode[26];
            }
        }
        /** Initialize your data structure here. */
        TrieNode root = null;
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode tempRoot = root;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(tempRoot.children[c-'a'] == null){
                    tempRoot.children[c-'a'] = new TrieNode();
                }
                tempRoot = tempRoot.children[c-'a'];
            }
            tempRoot.end = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode tempRoot = root;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(tempRoot.children[c-'a'] == null){
                    return false;
                }
                tempRoot = tempRoot.children[c-'a'];
            }
            return tempRoot.end;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode tempRoot = root;
            for(char c : prefix.toCharArray()){
                if(tempRoot.children[c-'a'] == null){
                    return false;
                }
                tempRoot = tempRoot.children[c-'a'];
            }
            return true;
        }
    }

}
