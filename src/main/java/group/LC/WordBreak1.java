package group.LC;

public class WordBreak1 {


    public boolean wordBreak(String s, List<String> wordDict) {
          
        if (s == null || s.length() == 0 || wordDict.size() == 0)
            return false;
        
        boolean[] f = new boolean[s.length()+1];
        f[0] = true; 
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                //System.out.println(s.substring(j,i));
                //f[j] is for the start of the word
                if(f[j] && wordDict.contains(s.substring(j,i))){
                    f[i] = true;
                    //this is where we set true if the entire word is present in the dict
                    break;
                }
            }
        }
        return f[s.length()];
    }
}