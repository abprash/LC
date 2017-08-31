/**
 * 
 */
package group.LC;

/**
 * @author abprashanth
 *
 *Write a function to find the longest common prefix string amongst an array of strings.
 */


public class LongestCommonPrefix {
	 public String longestCommonPrefix(String[] strs) {
	        //print only the most common prefix for ALL strings
	        //it should be present in all the strings
	        if(strs == null)
	            return "";
	        if(strs.length == 0)
	            return "";
	        String testString = new String();
	        int initPosition = 0;
	        boolean notEqual = false, noMoreLength = false;
	        for(int i=0; ; i++){
	            int charPointer = i;
	            String currentString = strs[0];
	            if(charPointer >= currentString.length())
	                break;
	            char c = currentString.charAt(charPointer); 
	            for(int j=1 ; j<strs.length; j++){
	                int stringPointer = j;
	                String currentString2 = strs[stringPointer];
	                if(charPointer >= currentString2.length()){
	                    noMoreLength = true;
	                    break;
	                }
	                char tempChar = currentString2.charAt(charPointer);
	                if(c != tempChar){
	                    notEqual = true;
	                    break;
	                }
	            }
	            if(noMoreLength && !notEqual){
	                noMoreLength = false;
	                continue;
	            }
	            if(notEqual)
	                break;
	            else
	                testString+=c;
	            notEqual = false;
	            noMoreLength = false;
	            
	        }
	        return testString;
	    }
    
    public static void main(String args){
    	//launch it
    	
    }
}