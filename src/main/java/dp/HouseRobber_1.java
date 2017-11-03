package dp;

/*You are a professional robber planning to rob houses along a street. Each house has a certain 
 * amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent 
 * houses have security system connected and it will automatically contact the police if two adjacent houses were 
 * broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount 
of money you can rob tonight without alerting the police.
 * 
*/
public class HouseRobber_1 {


    public int rob(int[] nums) {
        //initial validation
        if(nums == null || nums.length == 0)
            return 0;
        //if there is only one house return it, since all houses have non neg nos.
        if(nums.length == 1)
            return nums[0];
        int robYes = 0; // value if rob house
        int robNo = 0; //value if rob house no
        for(int i=0; i<nums.length; i++){
            //lets rob the current house, so if we rob this, we ignore the last house
            int curRob = robNo + nums[i];
            //now we are checking if it is good to rob this house
            //accordingly we update the max to robNo... why??
            robNo = Math.max(robNo,robYes);
            
            //we are updating robYes to current house
            robYes = curRob;
        }
        //then we return the max of rob yes or rob no
        return Math.max(robYes, robNo);
        
    }
}