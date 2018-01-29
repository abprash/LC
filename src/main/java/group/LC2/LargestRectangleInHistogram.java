package group.LC2;

public class LargestRectangleInHistogram {


    public int largestRectangleArea(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0; i<=nums.length; i++){
            int height = (i < nums.length) ? nums[i] : 0;
            if(stack.isEmpty() || height >= nums[stack.peek()])
                stack.push(i);
            else{
                //we will go on popping until we encounter a val >= height
                int top = stack.pop();
                maxArea = Math.max(maxArea, nums[top] * (stack.isEmpty() ?  i : i - 1 - stack.peek()));
                //to keep i at the current place
                i--;
            }
        }
        return maxArea;
    }
}