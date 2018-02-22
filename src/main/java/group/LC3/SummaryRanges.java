package group.LC;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        //its sorted
        List<String> ans = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return ans;
        int i = 0;
        int guess = nums[0];
        int next = 0;
        while(i<nums.length){
            //if guess and nums[i] are equal, print them
            //keep guessing 
            //if true - keep incrementing one num to guess and incr the index
            int prev = nums[i];
            System.out.print(nums[i]+"->");
            while(i+1 < nums.length && nums[i]+1 == nums[i+1])
                i++;
            if(i < nums.length){
                next = nums[i];
                if(prev == next){
                    ans.add(Integer.toString(nums[i]));
                }
                else{
                    ans.add(Integer.toString(prev)+"->"+Integer.toString(next));
                }
                System.out.print(nums[i]+"\n");
            }
            i++;
        }
        
        return ans;
    }
}