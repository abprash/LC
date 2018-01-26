package group.LC2;
import java.util.*;

public class CombinationSum4 {

	int count = 0;
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;
        Set<List<Integer>> ans = new HashSet<List<Integer>>();
        backtrack(nums, 0, nums.length-1, new ArrayList<Integer>(), ans, target );
        //System.out.println(ans);
        return count;
    }
    
    
    public void backtrack(int[] nums, int start, int end, List<Integer> tempList, Set<List<Integer>> ans, int target){
        if(target == 0){
            //Collections.reverse(tempList);
            count++;
            //ans.add(new ArrayList(tempList));
            //reverse and add again
            //Collections.sort(tempList, Collections.reverseOrder());
            //ans.add(new ArrayList(tempList));
            return;
        }
        if(target < 0)//we have went beyond the num
            return;
        for(int i=start; i<= end; i++){
            //tempList.add(nums[i]);
            backtrack(nums, 0, end, tempList, ans, target - nums[i]);
            //tempList.remove(tempList.size()-1);
        }
    }
    
    public static void main(String[] args){
    	int[] nums = {4,2,1};
    	int[] nums2 = {1,2,3};
    	int target = 32;
    	System.out.println(new CombinationSum4().combinationSum4(nums2, target));
    	
    }
}