package group.LC4_swe;

public class MaxConsecutiveOnes2 {

    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int max = 1;
        int ones = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                int curr = check(nums, i);
                if(curr > max)
                    max = curr;
            }
            else
                ones++;
        }
        if(max == 1 && nums.length > 1 && ones > 1){
            //then there were no zeros in the array
            max = nums.length;
        }
        return max;
    }
    
    public int check(int [] nums, int pos){
        //basically we will expand from the position - left and right and keep counting the num of consecutive 1s.
        //if we encounter a zero on left or right pointer, we stop
        int left = pos-1;
        int right = pos+1;
        int ans = 1;//assuming the curr one is flipped
        
        //go right
        for(int i=right; i<nums.length; i++){
            if(nums[i] == 0)
                break;
            else
                ans++;
        }
        //go left
        for(int i=left; i>=0; i--){
            if(nums[i] == 0)
                break;
            else
                ans++;
        }
        return ans;
    }
}