package not_understanding;

//https://leetcode.com/problems/max-chunks-to-make-sorted/description/
//https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/113528/Simple-Java-O(n)-Solution-with-detailed-explanation

public class MaximumChunks {
	
    public int maxChunksToSorted(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int ans = 0;
        //have a max array
        int[] max = new int[nums.length];
        max[0] = nums[0];
        for(int i =1; i<max.length; i++){
            max[i] = Math.max(nums[i], max[i-1]);
        }
        for(int i=0; i<max.length; i++){
            if(max[i] == i)
                ans++;
        }
        System.out.println(Arrays.toString(max));
        return ans;
    }
}
