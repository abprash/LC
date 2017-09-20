package group.LC;

public class FindDuplicate {
	
	
	/*
	 * *
	 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public int findDuplicate(int[] nums) {
        //find the sum of the array (SArray)
        //find the min and max numbers (min and max)
        //calc the sum from min to max (total = 1 to n)
        //subtract the sum from (SArray - total)
        
        if(nums == null)
            return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int arraySum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<nums.length; i++){
            if(i == 0)
                sb.append(","+Integer.toString(nums[i])+",");
            else
                sb.append(Integer.toString(nums[i])+",");
        }
        int total = 0, ans = 0;
        String sbString = new String(sb);
        //System.out.println(sbString);
        for(int i=0; i< nums.length; i++){
            String temp = Integer.toString(nums[i]);
            String requiredString = ","+temp+",";
            int pos = sbString.indexOf(requiredString);
            int pos2 = sbString.indexOf(requiredString,pos+1);
            //System.out.println(pos+","+pos2);
            if(pos > -1 && pos2 > -1 ){
                //System.out.println("Here with : "+nums[i]);
                ans = nums[i];
                break;
            }
        }
        return ans;
    }

}
