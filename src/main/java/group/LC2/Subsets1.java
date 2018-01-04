package group.LC2;
import java.util.ArrayList;
import java.util.List;

public class Subsets1 {

    
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(nums == null || nums.length == 0)
            return ans;
        
        //not necessary as elements are distinct
        //Arrays.sort(nums);
        
        return backtrack(ans, new ArrayList<Integer>(), nums, 0);
    }
    
    public List<List<Integer>> backtrack(List<List<Integer>> ans, List<Integer> tempList, int[] nums, int start){
        System.out.println(tempList+","+start);
        //while adding, add a new object, from the existing list
        ans.add(new ArrayList<>(tempList));
        
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(ans, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
        return ans;
    }
}