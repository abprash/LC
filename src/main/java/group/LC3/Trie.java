package group.LC;

import java.util.ArrayList;
import java.util.List;

//********************CORRECT

class Trie {

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        //initial character for the root
        root.c = '/';
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word  == null || word.length() == 0)
            return;
        int len = word.length();
        TrieNode cur = root;
        for(int i=0; i<len; i++){
            char c = word.charAt(i);
            if(cur.letters[c-'a'] == null)
                cur.letters[c-'a'] = new TrieNode(c);

            cur = cur.letters[c-'a'] ;
        }
        cur.isEnd = true;
        //System.out.println(root.letters[0].letters[0].isEnd);
    }
    
    
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || word.length() == 0)
            return false;
        
        int len = word.length();
        TrieNode cur = root;
        for(int i=0; i<len; i++){
            char c = word.charAt(i);
            if(cur.letters[c-'a'] == null)
                return false;
                //cur.letters[c-'a'] = new TrieNode(c);
            cur = cur.letters[c-'a'] ;
        }
        return cur.isEnd;
    }
    
    

    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null)
            return false;
        
       
        int len = prefix.length();
        TrieNode cur = root;
        for(int i=0; i<len; i++){
            char c = prefix.charAt(i);
            if(cur.letters[c-'a'] == null)
                return false;
                //cur.letters[c-'a'] = new TrieNode(c);
            cur = cur.letters[c-'a'] ;
        }
        return true;
    }
    
    
}


class TrieNode{
    public boolean isEnd;
    public char c;
    public TrieNode[] letters = new TrieNode[26];
    
    public TrieNode(){}
    
    public TrieNode(char c){
        TrieNode newNode = new TrieNode();
        this.c = c;
        this.isEnd = false;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

public class Trie {
	
//*****************************INCORRECT
    
    Trie root;
    char c;
    List<Trie> nextNodes;
    boolean isEnd;
    /** Initialize your data structure here. */
    public Trie() {
        this.c = '/';
        this.nextNodes = new ArrayList<>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(root == null){
            //this is our first node
            //create a new guy and start appending from there
            root = new Trie();
            root.c = '/';
            root.nextNodes = new ArrayList<>();
            helper(root, 0, word);
        }
        else{
            //we already have the root,
            helper(root, 0, word);
        }
    }
    
    public void helper(Trie node, int index, String word){
        if(word == null || index > word.length()-1 || node == null){
            
            return;//we have exceeded or the word is not present
        }
        
        //the word and index is valid
        char c = word.charAt(index);
        //System.out.println(c);
        boolean isFound = false;
        //now search for the char c in the root
        //go down one level and start searching
        if(node.nextNodes != null){
            for(Trie t : node.nextNodes){
                if(t != null && t.c == c){
                    if(index == word.length()-1){
                        node.isEnd = true;
                    }
                    helper(t, index+1, word);
                    isFound = true;
                    
                }
            }
        }
        //if we have not found it
        if(!isFound){
            Trie newNode = new Trie();
            newNode.c = c;
            nextNodes.add(newNode);
            node.nextNodes.add(newNode);
            helper(newNode, index+1, word);
        }

    }
    
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        //now we need to see if we can search node by node
        if(root == null)
            return false;
        if(word == null || word.length() == 0)
            return false;
        return searchHelper(root, 0, word);
        
    }
    
    
    public boolean searchHelper(Trie node, int index, String word){
        if(index > word.length()-1)
            return false;
        char c = word.charAt(index);
        System.out.println("==>"+c);
        //node.c will be '/' if i=0 (or) it will be something else
        if(node.nextNodes != null){
            for(Trie t : node.nextNodes){
                if(t != null && t.c == c && index == word.length()-1 && node.isEnd)
                    return true;
                if(t != null && t.c == c)
                    return searchHelper(t, index+1, word);
            }
            return false;
        }
        else
            return false;
    }
    public boolean startsWithHelper(Trie node, int index, String word){
        if(index > word.length()-1)
            return false;
        char c = word.charAt(index);
        System.out.println("==>"+c);
        //node.c will be '/' if i=0 (or) it will be something else
        if(node.nextNodes != null){
            for(Trie t : node.nextNodes){
                if(t != null && t.c == c && index == word.length()-1 )
                    return true;
                if(t != null && t.c == c)
                    return searchHelper(t, index+1, word);
            }
            return false;
        }
        else
            return false;
    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(root == null)
            return false;
        if(prefix == null || prefix.length() == 0)
            return false;
        return startsWithHelper(root, 0, prefix);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */