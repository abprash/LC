package group.LC;

public class PreOrderIterative {

}


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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        //so if doing a preorder traversal - always use a stack
        //and process in root - right and left order
        Stack<TreeNode> toVisit = new Stack<>();
        toVisit.push(root);
        while(!toVisit.isEmpty()){
            //so we first add the right one and then the left
            TreeNode visiting = toVisit.pop();
            ans.add(visiting.val);
            if(visiting.right != null)
                toVisit.push(visiting.right);
            if(visiting.left != null)
                toVisit.push(visiting.left);
        }
        return ans;
    }
}