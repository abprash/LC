package group.LC2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); 
        //we sort this because there are duplicates in nums
        Arrays.sort(nums);
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> tempList, int[] nums, int start){
        
        
        //this is correct
        //since there are duplicates, we should skip them
        //uncomment from here
        //if(!ans.contains(new ArrayList<>(tempList)))
        //to here
        
        ans.add(new ArrayList<>(tempList));
        for(int i=start; i<nums.length; i++){
            //skipping duplicates here
            if(i > start && nums[i] == nums[i-1]) continue;
            
            tempList.add(nums[i]);
            backtrack(ans, tempList, nums, i+1);
            //remove the last added element
            tempList.remove(tempList.size() - 1);
        }
    }
}