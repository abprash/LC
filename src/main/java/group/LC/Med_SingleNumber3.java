package com.leetcode.www;

/*
 *  Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5]. 
 * 
*/
public class Med_SingleNumber3 {
	public int[] singleNumber(int[] nums) {
	        if(nums.length == 0)
	            return nums;
	        int result = 0;
	        for(int i=0;i<nums.length;i++){
	            //do xor of each element
	            result ^= nums[i];
	        }
	        //we do this because we need to know where the rightmost bit is set, so that we will know
	        //since that bit is set, the constituent bits have to differ at that particular value
	        //thats how we group both of them
	        result &= -result;
	        int ans1 = 0, ans2 = 0;
	        for(int i=0; i<nums.length ; i++){
	            //
	            if((result & nums[i]) == 0)
	                ans1^= nums[i];
	            else
	                ans2^= nums[i];
	        }
	        return new int[]{ans1,ans2};
	    }

}
