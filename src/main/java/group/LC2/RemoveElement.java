package group.LC2;

public class RemoveElement {

}
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1 && nums[0] != val)
            return 1;
        int left = 0, right = nums.length-1;
        while(left < right){
            if(nums[left] == val && nums[right] == val){
                right--;
            }
            else if(nums[left] == val && nums[right] != val){
                //swap
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                right--;
            }
            else if(nums[left] != val && nums[right] == val){
                left++;
            }
            else if(nums[left] != val && nums[right] != val){
                left++;
            }
        }
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            
            if(nums[i] == val){
                break;
            }
            ans++;
        }
        return ans;
    }
}