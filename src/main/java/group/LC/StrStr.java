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
        //iterate thro the haystack now
        for(int i=0; i<haystack.length(); i++){
            haystackPointer = i;
            char haystackChar = haystack.charAt(i);
            if(needlePointer >= needle.length())
                break;
            char needleChar = needle.charAt(needlePointer);
            if(haystackChar == needleChar){
                startFlag = true;
                ans = i;
                //i++;
                //now iterate thro both needle and haystack
                for(int j=0; j<needle.length(); j++){
                    if(i>=haystack.length())
                        return -1;               
                    if(needle.charAt(j) == haystack.charAt(i)){
                        //all ok
                    }
                    else{
                        startFlag = false;
                        ans = -1;
                        break;
                        //end flag already false
                    }
                    i++;
                    if(j==needle.length()-1 && startFlag)
                        endFlag = true;
                }
                //endFlag = true;
                if(endFlag)
                    return ans;
                else{
                    startFlag = false; 
                    endFlag = false;
                    needlePointer = 0;
                }
            }
        }
        return ans;
    }

}
