package group.LC;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return 0;
        int ans = 0, temp = nums[0], count = 1, index=0;
       for(int i=0; i<nums.length-1; i++){
           if(nums[index] == nums[i+1])
               count++;//inc the count
           else
               count--;
           if(count == 0){
               //we set the required index here
               index = i+1;
               //and set the count to include the new number
               count = 1;
           }
       }
        return nums[index]; 
    }
}