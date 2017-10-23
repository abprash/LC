package group.LC;

public class JumpGame {
	
    public boolean canJump(int[] nums) {
        //the jump is only once and
        //from one index only
        //its not chaining of jumps
        //goes until the last element
        int reachable = 0;
        for(int i=0; i<nums.length; i++){
            if(i > reachable)
                return false;//we have encountered an element or elements which could not be jumped
            reachable = Math.max(reachable, i+nums[i]);
        }
        
        return true;
    }
}