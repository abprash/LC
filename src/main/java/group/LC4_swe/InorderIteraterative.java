package group.LC4_swe;

//https://leetcode.com/problems/binary-tree-inorder-traversal/description/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderIteraterative {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        //validate the input
        if(root == null)
            return ans;
        //objective - inorder iterative
        //now we start popping
        //when we pop, we are going to check the right child, if it exists
        while(root != null || !stack.isEmpty()){
            //we keep going left now
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode curr = stack.pop();
            ans.add(curr.val);
            root = curr.right;
        }
        return ans;
    }
}