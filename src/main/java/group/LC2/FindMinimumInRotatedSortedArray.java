package group.LC2;

public class FindMinimumInRotatedSortedArray {


	//Prashanth, you solved this.. you can do it again....
	
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        
        int low = 0, high = nums.length-1;
        int ans = 0;
        while(low < high){
            int mid = (low + high)/2;
            //base case
            if(high - low == 1){
                ans = nums[low] < nums[high] ? nums[low] : nums[high];
                break;
            }
            if(nums[low] < nums[high]){
                ans = nums[low];
                break;
            }
            
            //loop case
            if(nums[low] < nums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        //
        return ans;
    }
}