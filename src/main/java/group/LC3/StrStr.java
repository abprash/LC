/**
 * 
 */
package group.LC;

/**
 * @author abprashanth
 * Implement strStr().

  Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 */
public class StrStr {
	public int strStr(String haystack, String needle) {
        // a char pointer iterates all over the haystack
        //once the start chars match, -> startFlag = true, store this number
        //then keep iterating the pointer in both needle and haystack, keep comparing at the same time
        //if the needle end is reached and the haystack all match, then turn endFlag = true
        //return the first occurrence stored
        
        boolean startFlag = false, endFlag = false;
        int haystackPointer = 0, needlePointer = 0;
        int ans = -1;
        if(haystack == null || needle == null)
            return 0;
        if(haystack.length() < needle.length())
            return -1;
        if(!haystack.equals("") && needle.equals(""))
            return 0;
        if(haystack.equals("") && needle.equals(""))
            return 0;
        int initPos = 0, finalPos = -1;
        //iterate thro the haystack now
        for(int i=0; i<haystack.length(); i++){
            //check the first letter of needle with each letter of haystack
            //if its a match
            //go to loop below
            if(haystack.charAt(i) == needle.charAt(0)){
                //it has started
                initPos = i;
                startFlag = true;
                for(int j=0; j<needle.length(); j++){
                    //iterate thro the needle
                    if(i< haystack.length()){
                        if(needle.charAt(j) != haystack.charAt(i)){
                            //break out
                            startFlag = false;
                            i = initPos;
                            break;
                        }
                        if(j == needle.length()-1 && startFlag){
                            finalPos = initPos;
                            return finalPos;
                        }
                        i++;
                    }
                }
            }else{
                startFlag = false;
            }
            //else
            //keep repeating
        }
        return finalPos;
    }

}
