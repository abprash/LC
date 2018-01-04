package group.LC2;

import java.util.*;

public class Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        //
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return ans;
        //since there are duplicates, we need to sort them to eliminate duplicates
        Arrays.sort(nums);
        
        backtrack(ans, new ArrayList<>(), nums, new boolean[nums.length]);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> tempList, int[] nums, boolean[] used){
        if(tempList.size() == nums.length){
            ans.add(new ArrayList<>(tempList));
        }
        else{
            for(int i = 0; i < nums.length; i++){
                //take care of the repeating numbers
                //using a boolean array to take care of the positions used so far
                if(used[i] || (i>0 && (nums[i] == nums[i-1]) && !used[i-1])) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(ans, tempList, nums, used);
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }
}