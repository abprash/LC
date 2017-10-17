package group.LC;

/*
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].


 * 
 * 
*/
public class SearchRangeInSorted {

    public int[] searchRange(int[] nums, int target) {
        //we do a normal binary search
        //once we find the element
        //we simply go ahead and behind the same time to get the start and end indices
        
        if(nums == null || nums.length == 0)
            return new int[]{-1,-1};
        int[] ans = new int[2];
        boolean isFound = false;
        int start = 0, end = nums.length-1, pos = 0; 
        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] == target){
                isFound = true;
                pos = mid;
                break;
            }
            else if(target < nums[mid]){
                end = mid - 1;
            }
            else{
                start = mid+1;
            }
        }
        int forward = pos, backward = pos;
        
        if(isFound){
            //go back and forth to find the range
            while(forward < nums.length-1 && nums[forward+1] == target)
                forward++;
            while(backward > 0 && nums[backward-1] == target)
                backward--;
        }
        else
            return new int[]{-1,-1};
        return new int[]{backward, forward};
        
    }
}