package group.LC;

public class SortColors {

	    public void sortColors(int[] nums) {
	        //lets do counting sort
	        if(nums == null || nums.length == 0)
	            return;
	        int ones = 0, zeroes = 0, twos = 0;
	        for(int i=0; i<nums.length; i++){
	            if(nums[i] == 0)
	                zeroes++;
	            else if(nums[i] == 1)
	                ones++;
	            else if(nums[i] == 2)
	                twos++;
	        }
	        for(int i=0; i<nums.length; i++){
	            if(zeroes >0){
	                nums[i] = 0;
	                zeroes--;
	            }
	            else if(ones >0){
	                nums[i] = 1;
	                ones--;
	            }
	            else if(twos >0){
	                nums[i] = 2;
	                twos--;
	            }
	        }
	    }
	}