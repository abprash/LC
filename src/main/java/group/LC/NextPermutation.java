package group.LC;

/*
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 * 
 * 
*/public class NextPermutation {

	    public void nextPermutation(int[] nums) {
	        //initial validation
	        if(nums == null || nums.length <= 1)
	            return;
	        int i=nums.length - 1;
	        for(; i>=1; i--){
	            if(nums[i-1] < nums[i])
	                break;
	        }
	        
	        //lets first swap i-1 and its rightmost number which is greater than it
	        if(i != 0)
	            swap(nums, i-1);
	        
	        //now reverse from i to len-1
	        reverse(nums, i);
	        
	        
	    }
	    
	    public void swap(int[] nums, int left){
	        for(int right = nums.length - 1; right > left; right--){
	            if(nums[left] < nums[right]){
	                //swap them
	                int temp = nums[left];
	                nums[left] = nums[right];
	                nums[right] = temp;
	                break;
	            }
	        }
	    }
	    
	    public void reverse(int[] nums, int start){
	        int end = nums.length - 1;
	        while(start < end){
	            //simply reverse from i to len-1
	            int temp = nums[start];
	            nums[start] = nums[end];
	            nums[end] = temp;
	            start++;
	            end--;
	        }
	    }
	}