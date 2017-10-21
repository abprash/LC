package group.LC;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

/*
 * 
 * 
 * O(N^2) solution.... can be done better
 * 
 * 	
*/	
    public int[] maxSlidingWindow(int[] nums, int k) {
        //sliding window maximum
        if(nums == null )
            return null;
        if(nums.length == 0)
            return new int[0];
        
        if(nums.length == 1)
            return nums;
        
        //do the sliding window first
        int[] ans = new int[nums.length-k+1];
        int ansPointer = 0;
        for(int i=0;i<nums.length-k+1; i++){
            int max = Integer.MIN_VALUE;
            
            for(int j=0; j<k; j++){
                if(nums[j+i] > max)
                    max = nums[j+i];
            }
            ans[ansPointer] = max;
            ansPointer++;
        }
        return ans;
        
        
        
    }
    
    //*******SHITTY Solution
    
    public int[] maxSlidingWindowShitty(int[] nums, int k) {
        //sliding window maximum
        if(nums == null )
            return null;
        if(nums.length == 0)
            return new int[0];
        
        if(nums.length == 1)
            return nums;
        
        //get the first k elements, add them in a deque
        
        Deque<Integer> dq = new LinkedList<Integer>();
        int max1 = Integer.MIN_VALUE;
        int[] ans = new int[nums.length -k +1];
        for(int i=0; i<k ; i++){
            int val = nums[i];
            dq.addLast(nums[i]);
            if(val > max1)
                max1 = val;
        }
        
        ans[0] = max1;
        int count = 1;
        
        
        for(int i=k; i<nums.length ; i++){
            
            //remove the top one
            
            dq.removeFirst();
            
            //keep pushing the element into the end part of the queue
            
            dq.addLast(nums[i]);
            
            //compute the max
            Iterator<Integer> iter = dq.iterator();
            int max = Integer.MIN_VALUE;
            while(iter.hasNext()){
                int val = iter.next();
                if(val > max)
                    max = val;
            }
            ans[count] = max;
            //store in ans array
            
            count++;
        }
        
        return ans;
        
    }
    
    public static void main(String[] args){
    	Deque<Integer> dq = new LinkedList<Integer>();
    	
    	
    }
}