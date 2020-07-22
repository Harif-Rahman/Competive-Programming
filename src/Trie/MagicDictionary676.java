package Trie;

public class MagicDictionary676 {
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello","hallo","leetcode"});
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hhllo"));

    }
    static class MagicDictionary {
        TrieNode root = null;
        /** Initialize your data structure here. */
        public MagicDictionary() {
            root = new TrieNode();
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            for(String str : dict){
                TrieNode node = root;
                StringBuilder stringBuilder = new StringBuilder();
                for(char c : str.toCharArray()){
                    if(node.nodes[c-'a'] == null){
                        node.nodes[c-'a'] = new TrieNode();
                    }
                    stringBuilder.append(c);
                    node.word = stringBuilder.toString();
                    node = node.nodes[c-'a'];
                }
                node.isWord = true;
                node.word = str ;
            }
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {
            TrieNode node = root;
            for(int p = 0;p<word.length();p++){
                char c = word.charAt(p);
                if(node.nodes[c-'a'] == null){
                    for(int i=0;i<26;i++){
                        if(node.nodes[i] != null){
                            if(searchInMagicDict(word.substring(p+1),node.nodes[i])){
                                return true;
                            }
                        }
                    }
                    return false;
                }
                node = node.nodes[c-'a'];
            }
            return false;
        }
        private boolean searchInMagicDict(String word,TrieNode root){
            for(char c : word.toCharArray()){
                if(root.nodes[c-'a'] == null){
                    return false;
                }
                root = root.nodes[c-'a'];
            }
            return root.isWord;
        }
        class TrieNode{
            boolean isWord = false;
            String word = "";
            TrieNode[] nodes = null;
            TrieNode(){
                nodes = new TrieNode[26];
            }
        }
    }
}
