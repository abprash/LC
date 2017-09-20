package group.LC;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.*/
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class IsSameTree {
	Queue<Integer> l = (Queue<Integer>) new ArrayList<Integer>();
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //lets dfs
        dfs(p,1);
        dfs(q,2);
        if(l1.equals(l2))
            return true;
        else
            return false;
    }
    
    public void dfs(TreeNode root, int i){
        if(root != null){
            //System.out.println(root.val);
            if(i == 1){
                l1.add(root.val);
                dfs(root.left,1);
            dfs(root.right,1);
            }
            else if( i == 2){
                l2.add(root.val);
                dfs(root.left,2);
            dfs(root.right,2);
            }
            
        }
        else{
            if(i==1)
                l1.add(0);
            else
                l2.add(0);
        }
    }
    
    
    
    /////******************* excellent REcursive solution
    public boolean isSameTree2(TreeNode p, TreeNode q){
    	if(p == null && q == null)
    		return true;
    	if(p == null || q == null)
    		return false;
    	return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
    }
    
}