package group.LC;

public class PermutationInString {

    //public List<Integer> findAnagrams(String s, String p) {
    public boolean checkInclusion(String s1, String s2) {
        //initial validation
        if(s1 == null || s2 ==null || s1.length() == 0 || s2.length() > s2.length())
            return false;
        //get our occurrences array
        //int[] occurrences = getOccurrences(p);
        List<Integer> ans = new ArrayList<>();
        for(int i=s2.length()-1; i>=s1.length()-1; i--){
            char c = s2.charAt(i);
            //once we find a char which is in p, we substring the length and then verify if its an anagram
            if(s1.contains(c+"")){
                boolean isOk = false;
                isOk = isAnagram(s2.substring(i-s1.length()+1,i+1), s1);
                if(isOk){
                    return true;
                    //move i ahead
                    //i=i-p.length();
                }
            }
        }
        return false;
        //return ans;
    }
    
    public int[] getOccurrences(String p){
        //intial validation
        if(p == null)
            return null;
        //only lower case alphabets
        int[] key = new int[26];
        for(int i=0; i<p.length(); i++){
            key[p.charAt(i) - 'a']++;
        }
        return key;
    }
    public boolean isAnagram(String test, String p){
        //System.out.println(test+","+p);
        //will check test against p if its an anagram
        if(p == null || test == null)
            return false;
        if(p.length() != test.length())
            return false;
        int[] key = getOccurrences(p);
        for(int i=0; i<test.length(); i++){
            key[test.charAt(i)-'a']-=1;
        }
        //now verify
        int sum = 0;
        for(int i=0; i<key.length; i++){
            sum+=key[i];
            if(sum!=0)
                return false;
        }
        return true;
    }
}