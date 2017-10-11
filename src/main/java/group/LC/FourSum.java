package group.LC;

public class FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    if(nums.length<4)return ans;
    Arrays.sort(nums);
    //start iterating
    for(int i=0; i<nums.length-3; i++){
        //should check if the number is largest - break
        if(nums[i] + nums[i+1]+ nums[i+2]+ nums[i+3] > target)  break;

        //should go ahead if the number is too small - continue
        if(nums[i]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3] < target) continue;
        //should go ahead if there are duplicates - because they have already been done in the prev round
        if(i>0 && nums[i] == nums[i-1])    continue;
        for(int j=i+1; j<nums.length-2; j++){
            //should check if the number is largest - break
            if(nums[i] + nums[j]+ nums[j+1]+ nums[j+2] > target)  break;

            //should go ahead if the number is too small - continue
            if(nums[i]+nums[j]+nums[nums.length-1]+nums[nums.length-2] < target) continue;
            //should go ahead if there are duplicates - because they have already been done in the prev round
            if(j>i+1 && nums[j] == nums[j-1])    continue;
            int low = j+1, high = nums.length-1;

            while(low<high){
                int sum = nums[i]+nums[j]+nums[low]+nums[high];
                if(sum == target){
                    ans.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                    while(low<high && nums[low] == nums[low+1])    low++;
                    while(low<high && nums[high] == nums[high-1])    high--;
                    //this is a very imporant step
                    //this ensures that we eliminate the duplicates first then we shift the bounds
                    low++;
                    high--;
                }
                else if(sum < target)low++;
                else    high--;
            }
        }

    }
    return ans;
    }
}