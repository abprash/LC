package group.LC4;

//https://leetcode.com/problems/wiggle-sort/description/
public class WiggleSort {

    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        for(int i=0; i<nums.length-1; i++){
            if(i % 2 == 0){
                //even position - so next one should always be more or equal
                if(nums[i+1] < nums[i])
                    swap(nums, i, i+1);
            }
            else{
                //odd -> next one should always be lesser or equal
                if(nums[i+1] > nums[i])
                    swap(nums, i, i+1);
            }
        }
    }
    
    public void swap(int[] nums, int i,  int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
