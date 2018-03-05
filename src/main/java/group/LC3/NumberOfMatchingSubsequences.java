package group.LC3;

public class NumberOfMatchingSubsequences {


	//https://leetcode.com/problems/number-of-matching-subsequences/description/
	
	//https://leetcode.com/problems/number-of-matching-subsequences/discuss/117655/Clean-java-solution-using-HashSet
	
    public int numMatchingSubseq(String s, String[] words) {
        Set<String> valid = new HashSet<>(), invalid = new HashSet<>();
        int count = 0;
        for(String word : words){
            //
            if(valid.contains(word)){
                count++;
                continue;
            }
            if(invalid.contains(word))
                continue;
            
            if(isSubsequence(s, word)){
                valid.add(word);
                count++;
            }
            else{
                invalid.add(word);
            }
            //System.out.println(word+",count = "+count);
        }
        return count;
    }
    
    public boolean isSubsequence(String big, String small){
        int i = 0, j = 0;
        if(small.length() > big.length())
            return false;
        i = big.indexOf(small.charAt(0));
        while(i>=0 &&  j>= 0 && i < big.length() && j < small.length()){
            if(big.charAt(i) == small.charAt(j)){
                i++;
                j++;
            }
            else
                i++;
        }
        return j == small.length();
    }
}