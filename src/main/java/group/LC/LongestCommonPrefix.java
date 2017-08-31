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
        boolean allEqual = false, noMoreLength = false;
        for(int i=0; i<strs.length; i++){
            char c = strs[i].charAt(initPosition);
            for(int j=0 ; j<strs.length; j++){
                char tempC = strs[j].charAt(initPosition);
                if(c != tempC){
                    allEqual = false;
                    break;
                }
            }
            if(!allEqual)
                break;
            testString = testString + c;
            initPosition++;
        }
        return testString;
    }
    
    public static void main(String args){
    	//launch it
    	
    }
}