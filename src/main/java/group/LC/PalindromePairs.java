package group.LC;

public class PalindromePairs {

	
	class Solution {
	    public List<List<Integer>> palindromePairs(String[] words) {
	        List<List<Integer>> ans = new ArrayList<>();
	        
	        if(words == null)
	            return ans;
	        boolean[] wordPalindromes = new boolean[words.length];
	        Map<String, Integer> map = new HashMap<>();
	        
	        for(int i=0; i<words.length; i++)
	            map.put(words[i],i);
	        
	        for(int i=0; i<words.length; i++){
	            for(int j=0; j<=words[i].length(); j++){
	                //get the two words
	                //very nice algo
	                String s1 = words[i].substring(0,j);
	                String s2 = words[i].substring(j);
	                if(isPalindrome(s1)){
	                    //reverse the other string
	                    //and check if its there in the map
	                    String s2Rev = new StringBuilder(s2).reverse().toString();
	                    if(map.containsKey(s2Rev) && map.get(s2Rev) != i){
	                        List<Integer> temp = new ArrayList<>();
	                        temp.add(map.get(s2Rev));
	                        temp.add(i);
	                        ans.add(temp);
	                    }
	                }
	                if(isPalindrome(s2)){
	                    //reverse the other string
	                    //and check if its there in the map
	                    String s1Rev = new StringBuilder(s1).reverse().toString();
	                    if(map.containsKey(s1Rev) && map.get(s1Rev) != i && s2.length() != 0){
	                        List<Integer> temp = new ArrayList<>();
	                        temp.add(i);
	                        temp.add(map.get(s1Rev));
	                        ans.add(temp);
	                    }
	                }
	            }
	        }
	        return ans;
	    }
	    
	    public boolean isPalindrome(String str){
	        int left = 0;
	        int right = str.length() - 1;
	        while (left <= right) {
	            if (str.charAt(left++) !=  str.charAt(right--)) return false;
	        }
	        return true;
	    }
	}
	
//Very naive implementation
	//*****************************TIME limit exceeded after 69/140 cases passed
	
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(words == null || words.length == 0)
            return ans;
        boolean[] wordPalindromes = new boolean[words.length];
        for(int i=0; i<words.length; i++){
            for(int j=i+1; j<words.length; j++){
                //get the two words
                String word1 = words[i]+words[j];
                if(isPalindrome(word1)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
                //if word1 is a palindrome
                    //add [i,j] to ans
                String word2 = words[j]+words[i];
                if(isPalindrome(word2)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(j);
                    temp.add(i);
                    ans.add(temp);
                }
                //if word2 is a palindrome
                    //add [j,i] in that order to ans
            }
        }
        return ans;
    }
    
    public boolean isPalindrome(String word){
        if(word == null)
            return false;
        if(word.length() <= 1)
            return true;
        char[] wordArray = word.toCharArray();
        int l = 0, r = word.length() - 1;
        while(l < r){
            //swap them
            if(wordArray[r] != wordArray[l])
                return false;
            l++;
            r--;
        }
        return true;
    }
}