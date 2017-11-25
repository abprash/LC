package group.LC;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        boolean isOdd = true;
        for(int i=0; i<nums.length-1; i++){
            if(isOdd){
                //if its in an odd position
                //the i th num should be lesser than the i+1 th num
                if(nums[i] > nums[i+1]){
                    //swap em
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
            else{
                //if its in an even position
                //the i th num should be greater than the i+1 th num
                if(nums[i] < nums[i+1]){
                    //swap em
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
            isOdd = !isOdd;
        }
    }
}

public class WiggleSort {

	static int s;
	public static void main(String[] args) throws UnknownHostException{
		int a = 5;
		boolean  b = false;
		System.out.println(s);
		System.out.println(InetAddress.getAllByName("sanfoundary.com"));
		System.out.println(InetAddress.getByName("sanfoundary.com"));
	}
	
	
	
   public void wiggleSort(int[] nums) {
	        
	        //sort them
        Arrays.sort(nums);
        
        //swap them alternately, this will work
        for(int i=1; i<nums.length-1; i+=2){
            int temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        }
        return;
    }
}
