package group.LC;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        //initial validation
        if(s == null || p==null || s.length() == 0 || s.length() < p.length())
            return new ArrayList<Integer>();
        //get our occurrences array
        int[] occurrences = getOccurrences(p);
        List<Integer> ans = new ArrayList<>();
        for(int i=s.length()-1; i>=p.length()-1; i--){
            char c = s.charAt(i);
            //once we find a char which is in p, we substring the length and then verify if its an anagram
            if(p.contains(c+"")){
                boolean isOk = false;
                isOk = isAnagram(s.substring(i-p.length()+1,i+1), p);
                if(isOk){
                    ans.add(i-p.length()+1);
                    //move i ahead
                    //i=i-p.length();
                }
            }
        }
        return ans;
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