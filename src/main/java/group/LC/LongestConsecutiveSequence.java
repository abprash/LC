package group.LC;

import java.util.PriorityQueue;

public class LongestConsecutiveSequence {

	///**********************ANSWER - O(N)
	
	class Solution {
	    public int longestConsecutive(int[] nums) {
	        
	        //initial validation
	        if(nums == null || nums.length == 0)
	            return 0;
	        if(nums.length == 1)
	            return 1;
	        int ans = 0;
	        Map<Integer, Integer> map = new HashMap<>();
	        for(int i=0; i<nums.length ; i++){
	            if(map.containsKey(nums[i])){
	                //duplicate value
	                continue;
	            }
	            else{
	                //its a new value
	                //search for the number before and after it
	                int before = map.containsKey(nums[i] - 1)? map.get(nums[i]-1) : 0;
	                int after = map.containsKey(nums[i] +1)? map.get(nums[i]+1) : 0;
	                
	                int sum = before + after + 1;
	                map.put(nums[i], sum);
	                ans = Math.max(sum, ans);
	                
	                //now we need to update those other values in the map as well, ie. left and right values to nums[i]
	                map.put(nums[i] - before, sum);
	                map.put(nums[i] + after, sum);
	            }
	        }
	        return ans;
	    }
	}
	
	
	
	
	//************************O(Nlog(N)) time complexity
	
	
	
	class Solution {
	    public int longestConsecutive(int[] nums) {
	        
	        //initial validation
	        if(nums == null || nums.length == 0)
	            return 0;
	        if(nums.length == 1)
	            return 1;
	        //lets try using a priority queue
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	        Set<Integer> set = new HashSet<>();
	        for(int i=0; i<nums.length; i++){
	            if(!set.contains(nums[i])){
	                pq.add(nums[i]);
	                set.add(nums[i]);
	            }
	        }
	        int next = pq.peek();
	        int count = 0, maxCount = 0;
	        
	        while(!pq.isEmpty()){
	            //poll it
	            if(next == pq.peek()){
	                count++;
	                if(count > maxCount)
	                    maxCount = count;
	                next++;
	                pq.poll();
	            }
	            else{
	                count = 0;
	                if(!pq.isEmpty())
	                    next = pq.peek();
	                else
	                    break;
	            }
	            
	            //this is the min element
	            //now assign next to min+1
	            //if next == pq.poll()
	            //count++
	            //else count = 0
	            //System.out.println(pq.poll());
	        }
	        return maxCount;
	    }
	}
	 

	
	///***************************************TIME LIMIT EXCEEDED
    public int longestConsecutive(int[] nums) {
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	pq.peek
        //initial validation
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        //lets put everything into a hashmap first
        //duplicates are not considered
        //then start iterating from the min and max in the array
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            //put in the hashmap
            map.put(nums[i], 1);
            //at the same time calc the min and max
            if(nums[i] > max)
                max = nums[i];
            if(nums[i] < min)
                min = nums[i];
        }
        int maxCount = 0, count = 0;
        //System.out.println("max="+max);
        //System.out.println("min="+min);
        for(int i=min; i<= max; i++){
            //System.out.println(i);
            if(map.containsKey(i)){
                count++;
                if(count > maxCount)
                    maxCount  = count;
            }
            else
                count = 0;
        }
        return maxCount;
    }
}