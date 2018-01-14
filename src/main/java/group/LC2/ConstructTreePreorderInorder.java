package group.LC2;

public class ConstructTreePreorderInorder {

public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        //ref - https://articles.leetcode.com/construct-binary-tree-from-inorder-and-preorder-postorder-traversal/
        if(inorder == null || preorder == null || inorder.length == 0 || preorder.length == 0)
            return null;
        return helper(0, preorder.length - 1, 0, preorder, inorder);
    }
    
    public TreeNode helper(int inStart, int inEnd, int preStart, int[] preorder, int[] inorder){
        
        //check validity of start and end
        if (preStart > preorder.length - 1 || inStart > inEnd) {
        return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        //now we need to split inorder into two arrays based on the root value
        
        int rootIndex = 0;
        //first - the first element in preorder is the root,
        for(int i=inStart; i<= inEnd; i++){
            if(root.val == inorder[i]){
                rootIndex = i;
                break;
            }
        }
        root.left = helper(inStart, rootIndex - 1, preStart + 1,  preorder, inorder);
        root.right = helper(rootIndex+1, inEnd, preStart + rootIndex - inStart + 1, preorder, inorder);
        
        
        return root;
    }
}
