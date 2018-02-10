package group.LC2;

public class FirstMissingPositiveNum {

}

//https://leetcode.com/problems/first-missing-positive/discuss/17071/My-short-c++-solution-O(1)-space-and-O(n)-time
//

//https://leetcode.com/problems/first-missing-positive/description/
class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 1;
        int len = nums.length;
        for(int i=0; i<len; i++){
            //to ignore negative nos,
            //basically we try to swap and place nos at the correct places. eg. 5 in nums[5-1] or nums[4] etc.
            while(nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] -1])
                swap(nums, i, nums[i]-1);
        }
        //now we return the first +ve num which does not match
        for(int i=0; i<len; i++)
            if(nums[i] != i+1)
                return i+1;
        return len+1;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}