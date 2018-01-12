package group.LC;


//Alternate approach
class Solution {
    public int majorityElement(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return 0;
        //we need the index, count and the num to be stored
        int index = 0, count = 0, num = 0;
        for(int i=0; i<nums.length; i++){
            //this is the first element
        	if(i == 0){
                num = nums[i];
                count = 1;
                index = 0;
            }
            else{
            	//if num and nums[i] are equal
                if(nums[i] == num)
                    count++;
                else{
                    //this is a diff num, so reduce the count
                    count--;
                    //if count reached 0, then we change num to curr element 
                    if(count == 0){
                        num = nums[i];
                        index = i;
                        count = 1;
                    }
                }
            }
        }
        return num;
    }
}

/////////////////////////////////////////////
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
}