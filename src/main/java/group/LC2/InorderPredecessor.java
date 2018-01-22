package group.LC2;

public class InorderPredecessor {
	public TreeNode inorderPredecessor(TreeNode root, TreeNode p){
		if(root == null)
			return null;
		if(root.val >= p.val){
			//the root value is greater than p, so we go further left
			return inorderPredecessor(root.left, p);
		}
		else{
			//root value is lesser
			TreeNode right = inorderPredecessor(root.right, p);
			if(right != null)
				return right;
			else return root;
		}
	}

}
