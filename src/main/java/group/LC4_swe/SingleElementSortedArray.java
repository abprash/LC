package group.LC4_swe;

//https://leetcode.com/problems/single-element-in-a-sorted-array/description/

public class SingleElementSortedArray {

	
	public int singleNonDuplicate(int[] nums) {
        //O(log N) -> go with binary search :P - should be getting it easily
        if(nums == null || nums.length == 0)
            return 0;
        int hi = nums.length-1, lo = 0;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(mid-1 < 0 || (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) || mid+1 >= nums.length)
                return nums[mid];//this is our reqd number
            if((mid %2 == 0 && nums[mid-1] == nums[mid]) || (mid%2 != 0 && nums[mid+1] == nums[mid])){
                //go left
                hi = mid;
            }
            else{
                //go right
                lo = mid+1;
            }
        }
        return nums[lo];
    }
}