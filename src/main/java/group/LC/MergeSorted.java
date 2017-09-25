package group.LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MergeSorted {
	
	/*
	 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
The number of elements initialized in nums1 and nums2 are m and n respectively.
	 * 
	 * 
	 * 
	 * 
	 * 
	*/
	//***** With extra mem
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j=0, k=0;
        int[] sortedArray = new int[m+n];
        while(i<m || j<n){
            if(i < m && j < n){
                //compare both and put them in the new array
                if(nums1[i] < nums2[j]){
                    sortedArray[k] = nums1[i];
                    i++;
                }
                else{
                    sortedArray[k] = nums2[j];
                    j++;
                }
                k++;
            }
            else{
                if(i >= m){
                    //keep putting the rest of nums2 into nums3
                    while(j<n){
                        sortedArray[k] = nums2[j];
                        j++;
                        k++;
                    }
                }
                else if( j >= n){
                    while(i<m){
                        sortedArray[k] = nums1[i];
                        i++;
                        k++;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(sortedArray));
    }
	
	//**************************************actual good method
	public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.asList(new int[] {1});
        ans.add(Arrays.asList(new int[]{root.val}));
        while(q.size() > 0){
            List<Integer> tempList = new ArrayList<>();
            TreeNode current = q.remove();
            System.out.println("->"+current.val);
            //tempList.add(current.val);
            if(current.left != null){
                q.add(current.left);
                tempList.add(current.left.val);
            }
            if(current.right != null){
                q.add(current.right);
                tempList.add(current.right.val);
            }
            ans.add(tempList);
        }
        return ans;
    }
	

}
