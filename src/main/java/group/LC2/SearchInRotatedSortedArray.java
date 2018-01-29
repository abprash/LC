package group.LC2;

public class SearchInRotatedSortedArray {

	//Prashanth you wrote this program... Relax you'll do well.
	//Just think out loud and relax 

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid])
                    high = mid;
                else
                    low = mid + 1;
            }
            else{
                if(target <= nums[high] && target > nums[mid])
                    low = mid+1;
                else
                    high = mid;
                    
            }
        }
        return -1;
    }
}