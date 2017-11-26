package group.LC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfSmallerNumbersAfterSelf {

	
	
	//*****************BETTER IMPLEMENTATION***************USING BST approach

public class Solution {
    class Node {
        Node left, right;
        int val, sum, dup = 1;
        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }
    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        //if node is null, we are just creating a new node here, so update the val and put the sum so far in the ans
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            //we have a duplicate
            //inc the dup count
            node.dup++;
            //set ans[i] to preSum + curr node sum
            ans[i] = preSum + node.sum;
        } else if (node.val > num) {
            //we are going left, so that means the num above is smaller, so we incr the count
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            //we are going right, so we will be adding the sum so far with the num of duplicates + curr node sum
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }
}

	//*********************VERY NAIVE IMPLEMENTATION
	//time limit exceeded
	
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length == 1){
            ans.add(0);
            return ans;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++ )
            map.put(nums[i], i);
        for(int i=0; i<nums.length; i++){
            int cur = nums[i];
            int count = 0;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j] < cur)
                    count++;
            }
            ans.add(count);
            count = 0;
        }
        return ans;
    }
    
    public static void main(String[] args){
    	
    	//
    	ArrayList<Integer> list = new ArrayList<>();
    	list.add(10);
    	list.add(1,10);
    	System.out.println(list);
    }
}