package group.LC2;

public class DeleteNodeBST {

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
/*

Recursively find the node that has the same value as the key, while setting the left/right nodes equal to the returned subtree

Once the node is found, have to handle the below 4 cases

-> node doesn’t have left or right - return null
-> node only has left subtree- return the left subtree
-> node only has right subtree- return the right subtree
-> node has both left and right - find the minimum value in the right subtree, set that value to the currently found node, then recursively delete the minimum value in the right subtree

*/
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
        if(key < root.val)
            root.left = deleteNode(root.left, key);
        else if(key > root.val)
            root.right = deleteNode(root.right, key);
        else{
            //
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            //now we have the node to delete
            //find min in the right subtree
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        
        return root;
    }
    
    public TreeNode findMin(TreeNode root){
        while(root.left != null )
            root = root.left;
        return root;
    }
}
//straightforward brute solution
//74/85 cases passed
//not advisable to do this in an interview... very complicated and inefficient

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
    TreeNode cur = null, parent = null;
    
    public TreeNode deleteNode(TreeNode root, int key) {
        //
        if(root == null)
            return root;
        if(root.val == key && root.left == null && root.right == null)
            return null;
        //now start traversing
        boolean isPresent = findNode(root, key);
        if(!isPresent)
            return root;//not present, so we return root
        //check if the cur node is a leaf
        if(cur.left == null && cur.right == null){
            //its a leaf
            //modify parent pointer and return
            if(parent.left != null && parent.left.val == cur.val)
                parent.left = null;
            else
                parent.right = null;
            return root;
        }
        //else its not a leaf node, its in between edges
        
        //either get the rightmost leaf in the left subtree or the left most val in the right subtree - 
        if(cur.left != null){
            //left subtree explore
            TreeNode right = cur.left, par = cur;
            if(right.right == null){
                cur.val = right.val;    
                cur.left = null;
                return root;
            }
            while(right != null && right.right != null){
                par = right;
                right = right.right;
            }
            //right is now the parent node for the rightmost node
            //copy this value to cur and free right.right
            cur.val = right.val;
            par.right = null;
        }
        else{
            //right subtree explore
            TreeNode left = cur.right, par = cur;
            if(left.left == null){
                cur.val = left.val;    
                cur.right = null;
                return root;
            }
            while(left != null && left.left != null){
                par = left;
                left = left.left;
            }
            //right is now the parent node for the rightmost node
            //copy this value to cur and free right.right
            cur.val = left.val;
            par.left = null;
        }
        return root;
    }
    
    public boolean findNode(TreeNode root, int key){
        if(root == null)
            return false;
        if(key < root.val){
            parent = root;
            return findNode(root.left, key);//go left
        }
        else if(key > root.val){
            parent = root;
            return findNode(root.right, key);//go right
        }
        else{
            //System.out.println(parent.val);
            cur = root;
            return true;
        }
    }
}