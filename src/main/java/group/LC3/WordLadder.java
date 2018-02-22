package group.LC;

public class WordLadder {

	//minor modification - BFS solution
	
	
	
	class Solution {
	    
	    public int ladderLength(String beginWord, String endWord, List<String> wordList2) {
	        if(beginWord == null || endWord == null || wordList2 == null)
	            return 0;
	        if(beginWord.length() == 0 || endWord.length() == 0 || wordList2.size() == 0)
	            return 0;
	        //have a begin set and end set
	        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), visited = new HashSet<>(), wordList = new HashSet<String>();
	        wordList.addAll(wordList2);
	        beginSet.add(beginWord);
	        endSet.add(endWord);
	        int len = 1;
	        while(!beginSet.isEmpty() && !endSet.isEmpty()){
	            //should only enter if there are words in beginset and endset -> because they are our start and end points
	            //here we swap if the beginset is bigger than the endSet ....
	            // if(beginSet.size() < endSet.size()){
	            //     //why are we doing this???? i do not get it
	            //     Set<String> set = beginSet;
	            //     beginSet = endSet;
	            //     endSet = set;
	            // }
	            Set<String> tempSet = new HashSet<String>();
	            for(String word : beginSet){
	                char[] cArray = word.toCharArray();
	                for(int i=0; i<word.length(); i++){
	                    for(char c = 'a'; c<='z'; c++){
	                        //we iterate thro all the possible letters and check
	                        char old = cArray[i]; 
	                        cArray[i] = c;
	                        String newWord = String.valueOf(cArray);
	                        if(endSet.contains(newWord)){
	                            if( wordList.contains(newWord))
	                                return len+1;
	                            else
	                                return 0;
	                        }
	                        //System.out.println(tempSet);
	                        if(!visited.contains(newWord) && wordList.contains(newWord)){
	                            tempSet.add(newWord);
	                            visited.add(newWord);
	                        }
	                        //backtracking so that same array can be used
	                        cArray[i] = old;
	                    }
	                }
	            }
	            beginSet = tempSet;
	            len++;
	        }
	        return 0;
	    }
	}
	
	
	//*******************************************************

    public int ladderLength(String beginWord, String endWord, List<String> wordList2) {
    	if(beginWord == null || endWord == null || wordList2 == null)
            return 0;
        if(beginWord.length() == 0 || endWord.length() == 0 || wordList2.size() == 0)
            return 0;
        //have a begin set and end set
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), visited = new HashSet<>(), wordList = new HashSet<String>();
        wordList.addAll(wordList2);
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            //should only enter if there are words in beginset and endset -> because they are our start and end points
            //here we swap if the beginset is bigger than the endSet ....
            if(beginSet.size() < endSet.size()){
                //why are we doing this???? i do not get it
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> tempSet = new HashSet<String>();
            for(String word : beginSet){
                char[] cArray = word.toCharArray();
                for(int i=0; i<word.length(); i++){
                    for(char c = 'a'; c<='z'; c++){
                        //we iterate thro all the possible letters and check
                        char old = cArray[i]; 
                        cArray[i] = c;
                        String newWord = String.valueOf(cArray);
                        if(endSet.contains(newWord)){
                            if( wordList.contains(newWord))
                                return len+1;
                            else
                                return 0;
                        }
                        //System.out.println(tempSet);
                        if(!visited.contains(newWord) && wordList.contains(newWord)){
                            tempSet.add(newWord);
                            visited.add(newWord);
                        }
                        //backtracking so that same array can be used
                        cArray[i] = old;
                    }
                }
            }
            beginSet = tempSet;
            len++;
        }
        return 0;
    }
    
    
    public static void main(String[]  args){
		
		String beginWord = "";
		int index= 0;
		String dupBeginWord = new String(beginWord);
		for(char c='a'; c<='z'; c++){
            //subs it at index given
			beginWord.toCharArray()[index] = c;
            String temp = new String(beginWord);
            
        }
	}
}