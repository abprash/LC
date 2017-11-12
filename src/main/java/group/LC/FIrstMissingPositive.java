/**
 * 
 */
package group.LC;

/**
 * @author abprashanth
 *
 */
/*
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.


 * 
 * */
//************************************************ Does not use constant space at the moment


public class FIrstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        //initial validation
        if(nums == null || nums.length == 0)
            return 1;
        //put them all in a hashmap
        Map<Integer,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i : nums){
            map.put(i,1);
            if(i < min)
                min = i;
            if(i > max)
                max = i;
        }
        //get the min element
        
        //then start going from min element+1 to the max
        if(min > 1)
            min = 0;
        for(int i=min+1; i<=max+1; i++ ){
            if( i >0 && !map.containsKey(i))
                return i;
        }
        
        //the first positive element which is not in the hashmap - return it
        return 0;
    }
}