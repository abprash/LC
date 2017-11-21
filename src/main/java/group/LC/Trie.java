package group.LC;

import java.util.ArrayList;
import java.util.List;

public class Trie {

	//to store the chars
	List<Character> letters = new ArrayList<>();
	
	//to store the next pointers for each char
	List<Trie> root = new ArrayList<Trie>();

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new ArrayList<>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        //start parsing char by char and putting in a new node
        if(word == null || word.length() == 0)
            return;
        //int i = 0;
        //should be recursive
        helper(root, 0, word);
        // should insert each char in next level
        
        //
    }
    
    public void helper(List<Trie> root, int start, String word ){
    	if(root == null || start == word.length()-1)
    		return;
    	//insert the char in this level
    	
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */