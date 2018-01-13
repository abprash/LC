package group.LC2;

public class CombinationSum3 {

	
	
	
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), k, n, 1, 9);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> tempList, int k, int n, int start, int end){
        //both start and end are inclusive
        if(tempList.size() == k && n == 0){
            ans.add(new ArrayList(tempList));
            return;
        }
        for(int i=start; i<= end; i++){
        	//we will add this and try
            tempList.add(i);
            
            backtrack(ans, tempList, k, n-i, i+1, end);
            
            //if it reached here, then this number did not work out
            tempList.remove(tempList.size()-1);
        }
    }
}