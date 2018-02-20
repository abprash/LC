package group.LC3;

import java.util.*;

public class FactorCombinations {


	//much better solution
	
    int globalN = 0;
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        
        
        if(n <= 1)
            return ans;
        
        globalN = n;
        
        backtrack(ans, new ArrayList<Integer>(), 2, n);
        
        //System.out.println(ans);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> tempList, int start, int n){
        if(n == 1){
            
            if(tempList.size() >= 2){
                //Collections.sort(tempList);
                ans.add(new ArrayList(tempList));
            }
            return;
        }
        for(int i = start; i <= n; i++){
            if((n%i) == 0){
                tempList.add(i);
                backtrack(ans, tempList, i, n/i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
    

}

//15/20 cases passed
//still something wrong
class Solution {
    int globalN = 0;
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        
        if(n <= 1)
            return ans;
        
        globalN = n;
        
        backtrack(set, new ArrayList<>(), n-1, 2, n);
        ans.addAll(set);
        //System.out.println(ans);
        return ans;
    }
    
    public void backtrack(Set<List<Integer>> ans, List<Integer> tempList, int start, int end, int n){
        if(n <= 0)
            return;
        if(n == 1){
            //System.out.println("==>"+tempList);
            Collections.sort(tempList);
            int product = 1;
            //check if the product leads to n
            for(int i : tempList)
                product *= i;
            if(product == globalN)
                ans.add(new ArrayList(tempList));
            return;
        }
        for(int i=start; i>= end; i--){
            if((n % i) !=0)//use i only if it is a factor
                continue;
            tempList.add(i);
            backtrack(ans, tempList, start, end, n/i);
            tempList.remove(tempList.size()-1);
        }
    }
}