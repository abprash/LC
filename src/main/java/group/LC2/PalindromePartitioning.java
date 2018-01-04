package group.LC2;

import java.util.*;

public class PalindromePartitioning {


    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), s, 0);
        return ans;
    }
    
    public void backtrack(List<List<String>> ans, List<String> tempList, String s, int start){
        if(start == s.length()){
            ans.add(new ArrayList<>(tempList));
            return;
        }
        else{
            for(int i=start; i<s.length(); i++){
                if(isPalindrome(s, start, i)){
                    tempList.add(s.substring(start, i+1));
                    backtrack(ans, tempList, s, i+1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
    
    public boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }
            else
                return false;
        }
        return true;
    }
}