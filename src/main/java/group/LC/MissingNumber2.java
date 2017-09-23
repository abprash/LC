package group.LC;

public class MissingNumber2 {

	public int missingNumber(int[] nums) {
	       //two methods which are the best
	        //summing and xor
	        //XOR
	        //*********************************
	        // if(nums == null)
	        //     return 0;
	        // int ans = nums.length;
	        // for(int i=0; i<nums.length; i++){
	        //     ans^= i;
	        //     ans ^= nums[i];
	        // }
	        //return ans;
	        //*********************************
	        //summing
		//*********************************
			int l = nums.length;
	        int sum = l*(l+1)/2;
	        for(int i=0; i<l ; i++)
	            sum-=nums[i];
	        return sum;
	      //*********************************
	    }
}
