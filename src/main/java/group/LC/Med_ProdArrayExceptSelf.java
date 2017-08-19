package com.leetcode.www;

/*
 *  Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6]. 
 * 
*/
public class Med_ProdArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		// get the prod total
		long prodleft = 1, prod2 = 1;
		int[] ans = new int[nums.length];
		int inc = 1;
		for (int i = 1; i < nums.length; i++) {
			prodleft *= nums[i - 1];
			ans[i] = (int) prodleft;
		}
		int prodr = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (ans[i] == 0)
				ans[i] = 1;
			prodr *= nums[i + 1];
			ans[i] *= (int) prodr;
		}
		return ans;
	}

}
