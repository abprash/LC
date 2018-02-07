package group.LC2;


//https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78566/Java-intuitive-22ms-solution-with-stack

public class VerifyPreorderBT {

    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0)
            return true;
        //split with #
        String[] nums = preorder.split(",");
        Stack<String> stack = new Stack<>();
        
        
        for(int i=0; i<nums.length; i++){
            String num = nums[i];
            //if num push it
            while(num.equals("#") && !stack.isEmpty() && stack.peek().equals(num)){
                //if #,
                //check if stack top is #, keep popping the stack until, the top is not #
                stack.pop();
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
            
            //push the #
            stack.push(num);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}