package group.LC;





//***********************************MY solution

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        //initial validation
        //we will do a recursive dfs solution
        return dfs(s, wordDict, new HashMap<String, List<String>>());
    }
    
    public List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map){
        //first, if s is in the hashmap, return immeditaely
        //this is memoization for future strings
        if(map.containsKey(s))
            return map.get(s);
        
        List<String> ans = new ArrayList<>();
        //now check if the string is valid
        if(s.length() == 0){
            //string is empty
            ans.add("");
            return ans;
        }
        for(String word : wordDict){
            if(s.startsWith(word)){
                //word found
                String restOfWord = s.substring(word.length());
                List<String> subList = dfs(restOfWord, wordDict, map);
                for(String subWord : subList){
                    //now add the word to each entry
                    if(subWord.isEmpty())
                        subWord = word;
                    else
                        subWord = word +" " + subWord;
                    //add to our list
                    ans.add(subWord);
                }
                
            }
        }
        map.put(s, ans);
        return ans;
    }
}


public class WordBreak2 {


    public List<String> wordBreak(String s, List<String> wordDict) {
    	return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }       

	// DFS function returns an array including all substrings derived from s.
	public List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>>map) {
	    //map - string, list of strings - if its present in map, we return the list of strings
	    if (map.containsKey(s))
	        return map.get(s);
	
	    
	    LinkedList<String>res = new LinkedList<String>();     
	    //if length of the string is 0, we will simply add an empty string to the res
	    if (s.length() == 0) {
	        res.add("");
	        //return now itself
	        return res;
	    }     
	    //now iterate thro the word dict
	    for (String word : wordDict) {
	        //if the word is part of string s
	        if (s.startsWith(word)) {
	            //we will dfs down, to give the rest of the string to the next function
	            List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
	            //we will get a list of strings as return value
	            //append the new one further and return
	            for (String sub : sublist) 
	                res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
	        }
	    }
	    //System.out.println(map);
	    map.put(s, res);
	    return res;
	}
}