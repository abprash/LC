package group.LC;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;
        //sort the numbers
        Arrays.sort(nums);
        if(nums.length < 3)
            return 0;
        int ans = nums[0] + nums[1] + nums[nums.length - 1];
        for(int i=0; i<nums.length-2; i++){
            //keep j and k and moving both
            int low = i+1;
            int high = nums.length-1;
            int newTarget = target - nums[i];
            
            
            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                if(Math.abs(sum - target) < Math.abs(ans - target)){
                    //System.out.println(nums[i] +","+ nums[low] +","+ nums[high]);
                    ans = nums[i] + nums[low] + nums[high];
                    //System.out.println(ans);
                }
                if(nums[low] + nums[high] == newTarget){
                    //System.out.println(nums[i] +","+ nums[low] +","+ nums[high]);
                    low++;
                    high--;
                    while(low < high && nums[low] == nums[low-1])
                        low++;
                    while(low < high && nums[high] == nums[high+1])
                        high--;
                }
                else if(nums[low] + nums[high] < newTarget)
                    low++;
            else
                high--;
            
            }
        }
        return ans;
    }
    
    public static void main(String[] args){
    	
    }
}