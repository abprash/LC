package group.LC;

/*
 * 
 * A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * 
 * */
public class PeakElement {


    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 0;
        int maxIndex = Integer.MIN_VALUE;
        int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(i == 0 && nums[i] > left && nums[i] > nums[i+1] && i > maxIndex)
                maxIndex = i;
            else if(i == nums.length-1 && nums[i] > right && nums[i] > nums[i-1] && i > maxIndex)
                maxIndex = i;
            else if(i >= 1 && i < nums.length-1 && nums[i] > nums[i-1] && nums[i] > nums[i+1] && nums[i] > maxIndex)
                maxIndex = i; 
        }
        return maxIndex;
    }
}