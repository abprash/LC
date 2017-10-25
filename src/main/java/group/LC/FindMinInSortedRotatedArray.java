package group.LC;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class FindMinInSortedRotatedArray {

	//we have to do a O(log N) solution
    public int findMinLogN(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        
        int low = 0, high = nums.length-1;
        while(low < high){
            int mid = (low+high)/2;
            if(nums[mid] > nums[high]){
                //the min elt is in the left part.......... how????
                low = mid+1;
            }
            else {
                //min is in the right part......
                high = mid;
            }
            
        }
        return nums[low];
    }
	
	
	//Potentially O(N) solution
	//***********WHICH IS Shitty
	public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int min1 = nums[0];
        int p2 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        if(nums.length >= 2)
            p2 = 1;
        for(int p1=0;p1<nums.length-1; p1++, p2++){
            if(nums[p1] > nums[p2]){
                min2 = nums[p2];
                //return Math.min(min1, min2);
                break;
            }
            //p2= p1 + 1 ;
        }
        return  Math.min(min1, min2);
    }
	
	public static void main(String[] args){
		//we need to print the nano seconds
		
		
		long timeInMilliSeconds = Calendar.getInstance().getTimeInMillis();
		
		
		//Math.random()*10 + 1;
		for(int i=0; i<10; i++)
		System.out.println((int) ( Math.random()*100 ));
		Set<Integer> randomSet = new HashSet<>();
		int a = (int) randomSet.toArray()[0];
		
		
	}
}