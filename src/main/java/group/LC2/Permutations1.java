package group.LC2;

import java.util.List;
import java.util.*;

public class Permutations1 {

    public List<List<Integer>> permute(int[] nums) {
        //
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return ans;
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> tempList, int[] nums, int start){
        if(tempList.size() == nums.length){
            ans.add(new ArrayList<>(tempList));
        }
        else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i]))  continue;
                tempList.add(nums[i]);
                backtrack(ans, tempList, nums, i+1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}