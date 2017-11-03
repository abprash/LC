package dp;

public class RangeSumQueryImmutable {


	class NumArray {
	    int[] nums;
	    //Map<Pair, Integer> map = new HashMap<>();
	    public NumArray(int[] nums) {
	        this.nums = nums;
	    }
	    
	    public int sumRange(int i, int j) {
	        //lets try tail recursion
	        //yeah!! Java does not have tail recursion optimization!
	        int diff = j - i + 1;
	        return helper(diff, i, 0);
	    }
	    
	    public int helper(int more, int i, int sum){
	        if(more == 0)
	            return sum;
	        else
	            return helper(more-1, i+1, sum + nums[i]);
	    }
	}

}
/*
[1,2,3,4,5]

[1,3,6,10,15]



*/

class NumArray {
    int[] sums;
    //Map<Pair, Integer> map = new HashMap<>();
    public NumArray(int[] nums) {
        this.sums = nums;
        if(nums == null || nums.length == 0)
            return;
        sums[0] = nums[0];
        for(int i=1; i< nums.length; i++){
            sums[i] = sums[i-1]+nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        //lets try tail recursion
        //yeah!! Java does not have tail recursion optimization!
        if(i != 0)
            return sums[j] - sums[i-1];
        else
            return sums[j];
    }
    
    public int helper(int more, int i, int sum){
        if(more == 0)
            return sum;
        else
            return helper(more-1, i+1, sum + sums[i]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
