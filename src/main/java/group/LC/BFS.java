package group.LC;

public class BFS {
	
Queue<TreeNode> q = (Queue<TreeNode>) new LinkedList<TreeNode>();
    
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

}
