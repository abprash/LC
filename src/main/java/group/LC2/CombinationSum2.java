package group.LC2;

import java.util.*;

public class CombinationSum2 {


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(ans, new ArrayList<Integer>(), candidates, target, 0);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> tempList, int[] nums, int target, int start){
        if(target == 0){
            ans.add(new ArrayList<>(tempList));
            return;
        }
        else if(target < 0)
            return;
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            tempList.add(nums[i]);
            backtrack(ans, tempList, nums, target - nums[i], i+1);
            tempList.remove(tempList.size() - 1);
        }
    }
}