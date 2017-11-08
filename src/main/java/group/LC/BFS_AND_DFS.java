package group.LC;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS_AND_DFS {
	
Queue<TreeNode> q = (Queue<TreeNode>) new LinkedList<TreeNode>();
Stack<TreeNode> stack = new Stack<TreeNode>();

    public void Bfs(TreeNode root) {
        q.add(root);
        
        while(q.size() > 0){
            TreeNode temp = q.remove();
            System.out.println(temp.val);
            if(temp.left != null)
                q.add(temp.left);
            if(temp.right != null)
                q.add(temp.right);
        }
        return;
    }

    
    
    public void DFS_withStack(TreeNode root) {
    	stack.push(root);
        
        while(stack.size() > 0){
            TreeNode temp = stack.pop();
            System.out.println(temp.val);
            if(temp.left != null)
            	stack.push(temp.left);
            if(temp.right != null)
            	stack.push(temp.right);
        }
        return;
    }
}
