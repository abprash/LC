package group.LC2;

public class RemoveDuplicateElement2 {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int pos = 0;
        for(int num : nums){
            if(pos < 2 || num > nums[pos-2]){
                //now only we overwrite
                nums[pos++] = num;
            }
            else{
                // keep this pos locked, to overwrite with the next bigger num
            }
        }
        return pos;

        
    }
}