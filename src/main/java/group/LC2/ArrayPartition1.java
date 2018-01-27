package group.LC2;

import java.util.*;
/*
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which 
 * makes sum of min(ai, bi) for all i from 1 to n as large as possible.
*/

class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] ans = new int[20001];
        for(int i=0; i<nums.length; i++){
            ans[nums[i] + 10000]++;
        }
        boolean odd = true;
        int sum = 0;
        for(int i=0; i<ans.length; i++){
            while(ans[i] > 0){
                if(odd)
                    sum += (i - 10000);
                odd = !odd;
                ans[i]--;
            }
            
            
        }
        return sum;
    }
}


//***********************************

public class ArrayPartition1 {

}

// O(Nlog N) time complexity
// not great.. but AC solution
class Solution {
	public int arrayPairSum(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i += 2)
			sum += nums[i];
		return sum;
	}
}