package group.LC3;

public class SearchInsertPosition {


	//https://leetcode.com/problems/search-insert-position/description/
	
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;//whatever the num, just insert and return
        int low = 0, high = nums.length-1;
        
        //check the ends
        if(target < nums[0])
            return 0;
        if(target > nums[high])
            return nums.length;
        
        while(low <= high){
            if(low == high)
                return low;
            int mid =  low + (high-low)/2;
            if(nums[mid] == target)
                return mid; //since no duplicates
            if(target > nums[mid])
                low = mid+1;//second half
            else
                high = mid;
        }
        return high;
    }
}