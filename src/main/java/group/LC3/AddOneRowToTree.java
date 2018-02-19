package group.LC3;

public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d < 1)
            return root;
        
        //tree is empty
        if(root == null){
            return new TreeNode(v);
        }
        
        //do a bfs and solve it
        
        root = bfs(root, v, d, 1, 0);
        
        return root;
    }
    
    public TreeNode bfs(TreeNode root, int v, int d, int currD, int lr){
        //cases to handle
        //if row is empty - so creation of the new row
        //else if d row is non empty - we need to propagate the val below
        if(root == null){
            if(d == currD)
                return new TreeNode(v);//empty node handled
            else
                return null;
        }
        if(currD < d){
            //keep going down , no change
            root.left = bfs(root.left, v, d, currD+1, -1);
            root.right = bfs(root.right, v, d, currD+1, 1);
        }
        else if(currD == d){
            //replace the entire row
            TreeNode n1 = new TreeNode(v);
            if(lr == -1 || lr == 0)
                n1.left = root;
            else if(lr == 1)
                n1.right = root;
            return n1;
        }
        return root;
    }
}