package group.LC;

public class SingleNumber_2 {

	
	/*
	 * Much better optimal solution
	 * */
	
	    public int singleNumber(int[] nums) {
	        if(nums == null || nums.length == 0)
	            return 0;
	        int res = 0;
	        for(int i=0; i<32; i++){
	            int sum = 0;
	            for(int j=0; j<nums.length; j++){
	                //calc the sum
	                if(((nums[j] >> i) & 1 ) == 1){ // we check if there are more than n%3 occurrences and store them if needed
	                    sum++;//incr the count
	                    sum %= 3; // since the digits only occur three times at most
	                }
	            }
	             if(sum != 0){
	                    res = res | (sum << i); 
	                }
	        }
	        return res;
	    }

	/*
	 * Uses O(N) space
	 * */
	
	//
    public int singleNumber_belowParSolution(int[] nums) {
        
        
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int res = nums[0], ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=1; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int count = map.get(nums[i]);
                count++;
                map.put(nums[i],count);
            }
            else
                map.put(nums[i],1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                ans = entry.getKey();
                break;
            }
        }
        return ans;
    }
}