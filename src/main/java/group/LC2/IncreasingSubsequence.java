package group.LC2;

import java.util.*;
public class IncreasingSubsequence {


//DFS solution!!!!!!!!

//https://leetcode.com/problems/increasing-subsequences/discuss/97147/Java-solution-beats-100


    public List<List<Integer>> findSubsequences(int[] nums) {
     List<List<Integer>> rst = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return rst;
        }    
        dfs(rst, new ArrayList<Integer>(), 0, nums, -101);
        return rst;
    }
    
    private void dfs(List<List<Integer>> rst, List<Integer> path , int idx, int[] nums,int pre){
        if (path.size() >= 2){
            rst.add(new ArrayList(path));
        }
        if (idx == nums.length){
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++){
            if (set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            if (nums[i] >= pre){
                path.add(nums[i]);
                dfs(rst, path, i + 1, nums, nums[i]);
                path.remove(path.size() - 1);
            }
        }
    }
}