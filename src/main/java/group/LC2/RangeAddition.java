package group.LC2;

//https://leetcode.com/problems/range-addition/description/

//the clever solution!!!!!!

//https://leetcode.com/problems/range-addition/discuss/84217/Java-O(K-+-N)time-complexity-Solution

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        if(updates == null || updates.length == 0 || length == 0)
            return new int[length];
        int[] res = new int[length];
        for(int[] update : updates){
            int start = update[0];
            int end = update[1];
            int val = update[2];
            //update the start alone
            res[start] += val;
            
            //add the complement at the end+1 index
            if(end + 1 < res.length)
                res[end + 1] -= val;
        }
        
        int sum = 0;
        for(int i=0; i<length; i++){
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }
}


public class RangeAddition {

	
	//brute force
	
    public int[] getModifiedArray(int length, int[][] updates) {
        if(updates == null || updates.length == 0 || length == 0)
            return new int[length];
        int[] nums = new int[length];
        for(int[] update : updates){
            int start = update[0];
            int end = update[1];
            int val = update[2];
            for(int i=start; i<= end; i++)
                nums[i] += val;
        }
        return nums;
    }
}