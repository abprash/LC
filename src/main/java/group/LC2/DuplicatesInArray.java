package group.LC2;

public class DuplicatesInArray {


    public List<Integer> findDuplicates(int[] nums) {
        //the main restriction here being which makes this algo possible
        // Given an array of integers, 1 ≤ a[i] ≤ n
        List<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return ans;
        
        //core idea
        //while iterating thro the array
        //we go change the index to be negative of the current number just encountered
        //if already negative
        //add the number to the ans
        
        for(int i=0; i<nums.length; i++){
            //get the index to change 
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                ans.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return ans;
    }
}