package group.LC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsBinaryTree {



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null)
            return new ArrayList<Double>();
        
        //lets do a bfs
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Double> ans = new ArrayList<Double>();
        while(!q.isEmpty()){
            //get the size of the queue
            int size = q.size();
            double sum = 0;
            //List<Integer> temp = new ArrayList<>();
            for(int i=0; i<size; i++){
                //start doing the navigation
                TreeNode cur = q.poll();
                if(cur.left != null)
                    q.offer(cur.left);
                sum += cur.val;
                if(cur.right != null)
                    q.offer(cur.right);
            }
            //now calc the avg and add
            double avg = sum / size;
            ans.add(avg);
        }
        
        return ans;
    }
}