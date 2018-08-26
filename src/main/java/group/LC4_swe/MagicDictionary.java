package group.LC4_swe;

//https://leetcode.com/problems/implement-magic-dictionary/description/

//approach - https://leetcode.com/problems/implement-magic-dictionary/discuss/107453/Easiest-JAVA-with-Trie-no-need-to-count-the-number-of-changes
//much faster


class MagicDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(int i=0; i<dict.length; i++){
            TrieNode temp = root;
            for(int j=0; j<dict[i].length(); j++){
                char c = dict[i].charAt(j);
                if(temp.children[c-'a'] == null)
                    temp.children[c-'a'] = new TrieNode();
                temp = temp.children[c-'a'];//keep going down
            }
            temp.isWord = true;//mark the end of the word
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        TrieNode temp = root;
        for(int i=0; i<word.length(); i++){
           char c = word.charAt(i);
           for(int j=0; j<26; j++){
               //we now iterate through all the letters a-z
               if((char) (j + 'a') == c || temp.children[j] == null)
                   continue;//either the word is absent or the letter matches. we need to have a word off by one character
               if(helper(word, i+1, temp.children[j]))
                   return true;
           }
            if(temp.children[c-'a'] == null)
                return false;
            temp = temp.children[c-'a'];
        }
        return false;
    }
    
    public boolean helper(String word, int index, TrieNode temp){
        //the letter has already changed. now we need to simply go down and see if all other letters match
        for(int i=index; i< word.length(); i++){
            char c = word.charAt(i);
            if(temp.children[c-'a'] == null)
                return false;
            temp = temp.children[c -'a'];
        }
        return temp.isWord;
    }
}
class TrieNode{
    TrieNode[] children;
    boolean isWord;
    
    TrieNode(){
        children = new TrieNode[26];
        isWord = false;
    }
}
/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */

public class MagicDictionary {


//approach - https://leetcode.com/problems/implement-magic-dictionary/discuss/161127/Share-my-clean-and-easily-understandable-Java-code
//approach - not very efficient


    Map<String, Set<String>> map;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String str: dict) {
            for (int i = 0; i < str.length(); i++) {
                String tmp = str.substring(0, i) + "*" + str.substring(i+1, str.length());
                if (map.containsKey(tmp)) {
                    map.get(tmp).add(str);
                } else {
                    HashSet<String> set = new HashSet<>();
                    set.add(str);
                    map.put(tmp, set);
                }
            }
        }
        System.out.println(map);
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for(int i=0; i<word.length(); i++){
            String temp = word.substring(0,i) + "*" + word.substring(i+1);
            if(map.containsKey(temp)){
                Set<String> set = map.get(temp);
                if(set.size() == 1 && !set.contains(word) || (set.size() > 1))
                    return true;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */