package group.LC2;

import java.util.*;
public class CombinationSum1 {

	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        //validate the input array
	        if(candidates == null)
	            return null;
	        Arrays.sort(candidates);
	        //we may have to do some validation to save computation time
	        List<List<Integer>> ans = new ArrayList<>();
	        backtrack(ans, new ArrayList<Integer>(), candidates, 0, target );
	        return ans;
	    }

	    //Two methods which do the same thing....................
	    
	    public void backtrack(List<List<Integer>> ans, List<Integer> tempList, int[] nums, int start, int target){
	        if(target < 0)
	            return;//we have exceeded
	        else if(target == 0){
	            ans.add(new ArrayList<>(tempList));
	        }
	        else{
	            for(int i= start; i<nums.length; i++){
	                tempList.add(nums[i]);
	                backtrack(ans, tempList, nums, i, target  - nums[i]);
	                tempList.remove(tempList.size() - 1);
	            }
	        }
	    }
	    
	    public void getSum(List<List<Integer>> ans, int[] candidates, List<Integer> currList, int target, int start){
	        //start is where we should start from
	        if(target > 0){
	            //we will start looping thro only if the target has not been satisfied still
	            for(int i=start; i<candidates.length && target >= candidates[i] ; i++){
	                //we just add it into our temp list for now and resume computation
	                currList.add(candidates[i]);
	                //now we have added one element to our curr list, so we should update our call to the recursive func
	                getSum(ans, candidates, currList, target-candidates[i], i);
	                //if the flow reaches here, then this one did not work out, so we remove the last added element and try again
	                currList.remove(currList.size() - 1);
	            }
	        }
	        else if(target == 0)
	            ans.add(new ArrayList<Integer>(currList));
	    }
	}