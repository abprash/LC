package group.LC2;

public class MajorityElement2 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        //it is again similar to majority element problem
        if(nums == null || nums.length == 0)
            return ans;
        int count1 = 0, count2 = 0, num1 = nums[0], num2 = nums[0];
        
        
        for(int i=0; i<nums.length; i++){
            
            if(nums[i] == num1){
                count1++;
            }
            else if(nums[i] == num2 && num2 != num1){
                count2++;
            }
            else if(count1 == 0){
                    count1 = 1;
                    num1 = nums[i];
                }
            else if(count2 == 0){
                    count2 = 1;
                    num2 = nums[i];
                }
            else{    
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        //verify the counts
        for(int i=0; i<nums.length; i++){
            if(nums[i] == num1)
                count1++;
            else if(nums[i] == num2)
                count2++;
        }
        if(count1 > nums.length/3)
            ans.add(num1);
        if(count2 > nums.length/3 && num2 != num1)
            ans.add(num2);
        return ans;
    }
}