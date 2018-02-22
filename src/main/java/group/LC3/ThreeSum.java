package group.LC;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 * 
*/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null)
            return null;
        List<List<Integer>> res = new ArrayList<>();
        //sorting them so that the duplicate nos. will be right next to each other
        Arrays.sort(nums);
        for(int i=0; i<nums.length - 2; i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int j = i+1;
            int k = nums.length - 1;
            int target = -nums[i];
            while(j<k){
                
                if(nums[k] + nums[j] == target){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    //checking if the next num on the array is alaso a duplicate
                    while(j<k && nums[j] == nums[j-1])  j++;
                    while(j<k && nums[k] == nums[k+1])  k--;
                }
                else if(nums[j] + nums[k] > target)  k--;
                else
                    j++;
            }
        }
        return res;
    }
    
}