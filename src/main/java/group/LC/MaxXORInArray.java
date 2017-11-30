package group.LC;

public class MaxXORInArray {

}





//**************************** O(N^2) solution
//SHITTY solution

class Solution {
    public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if((nums[i] ^ nums[j]) > max)
                    max = nums[i] ^ nums[j];
            }
        }
        return max;
    }
}