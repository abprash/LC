package group.LC4;

//https://leetcode.com/problems/permutations/description/

public class Permutations {


    public List<List<Integer>> permute(int[] nums) {
        //backtracking question
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return ans;
        backtrack(ans,  new ArrayList<>(), nums, 0, nums.length-1);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start, int end){
        if(temp.size() == nums.length){
            //valid case
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(temp.size() > nums.length)
            return;//invalid case
        for(int i=start; i<=end; i++){
            //add the curr element to list
            if(!temp.contains(nums[i])){
                temp.add(nums[i]);
                //use this one and backtrack
                backtrack(ans, temp, nums, start, end);
                temp.remove(temp.size()-1);
            }
        }
    }
}