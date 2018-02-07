package group.LC2;

public class VerifyPreorderSequence {
	
	//Using O(N) space
	
	//basically while we keep traversing, the low value keeps increasing
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0)
            return true;
        Stack<Integer> stack = new Stack<>();
        int low = Integer.MIN_VALUE;
        for(int num : preorder){
            if(num < low)
                return false;
            //stack should not be empty and keep popping until we have removed all nos. lesser than num
            while(!stack.isEmpty() && num > stack.peek())
                low = stack.pop();//keep updating the low everytime we pop, since the nos will be lesser than low only
            //push the curr num
            stack.push(num);
        }
        return true;
    }
}

//very wrong implementation

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        //
        if(preorder == null || preorder.length == 0)
            return true;
        //preorder traversal will usually be in a sawtooth formation (generally)
        //so identify the peaks first
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<preorder.length; i++){
            if(i>0 && preorder[i] > preorder[i-1]){
                if(i+1<preorder.length && preorder[i] < preorder[i+1])
                    return false;
                else
                    list.add(i);//this is a peak
            }
        }
        return true;
    }
}
