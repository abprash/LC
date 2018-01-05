package group.LC2;

import java.util.ArrayList;
import java.util.List;

public class Combinations {


	
	public static void main(String[] args){
		StringBuilder sb = new StringBuilder();
		sb.del
	}
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i=1; i<=n; i++){
            nums[i-1] = i;
        }
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums, k, 0);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> tempList, int[] nums, int k, int start){
        if(tempList.size() == k){
            //add it to the ans
            ans.add(new ArrayList<>(tempList));
            return;
        }else{
            for(int i = start; i<nums.length; i++){
                tempList.add(nums[i]);
                backtrack(ans, tempList, nums, k, i+1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}