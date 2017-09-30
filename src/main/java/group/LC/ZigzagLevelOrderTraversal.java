package group.LC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 public class ZigzagLevelOrderTraversal {
	 
	 //**********************************************
	 //very hacky way of doing zig zag traversal 
	 //not the most appropriate way
	 //**********************************************

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int levelNumber = 1;
         while(!q.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            ///determine the size of the sublist
            int levelLength = q.size();
            for(int i=0; i<levelLength; i++){
                if(q.peek().left != null)
                    q.add(q.peek().left);
                if(q.peek().right != null)
                    q.add(q.peek().right);
                subList.add(q.remove().val);
            }
            if(levelNumber %2 == 0)
                Collections.reverse(subList);
            ans.add(subList);
            levelNumber++;
        }
        return ans;
    }
}
//********************************************************The beautiful recursive way
 /**
  * Definition for a binary tree node.
  * public class TreeNode {
  *     int val;
  *     TreeNode left;
  *     TreeNode right;
  *     TreeNode(int x) { val = x; }
  * }
  */
 class Solution {
     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> ans = new ArrayList<>();
         helper(ans, 0, root);
         return ans;
     }
     
     public void helper(List<List<Integer>> ans, int level, TreeNode root){
         if(root == null)
             return;
         if(ans.size() <= level)
             ans.add(new ArrayList<Integer>());
         
         if(level %2 == 0)
             ans.get(level).add(root.val);
         else
             ans.get(level).add(0, root.val);//here we reverse it on odd levels, as we are starting from 0
         
         helper(ans, level+1, root.left);
         helper(ans, level+1, root.right);
     }
 }
 
 //************Another way we can do is using two stacks
 //