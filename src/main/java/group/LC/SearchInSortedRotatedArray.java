package group.LC;

public class SearchInSortedRotatedArray {

    public int search(int[] nums, int target) {
        //cant we do a simple linear search??
        //we should do a binary search definitely
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] == target)
                return mid;
            //now this would be normal binary search
            if(nums[start] <= nums[mid]){
                if(target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            //but since this array is rotated, we have to check the other half also - until our condition breaks and we eliminate the broken part
            if(nums[mid] <= nums[end]){
                if(target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
           
        }
        return -1; 
    }
}