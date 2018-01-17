package group.LC2;

import java.util.*;

public class PostOrderIterative {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    
    
    //See this for reference
    //https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45621/
    
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            ans.add(0, cur.val);
            //now add the left one first, so that the right one will be popped next
            if(cur.left != null)
                stack.push(cur.left);
            if(cur.right != null)
                stack.push(cur.right);
        }
        return ans;
    }
}