package group.LC2;

public class UniqueBinarySearchTrees {


	
	    /*
	    
	    WE can know that by zero we can have 1 bst of null
	    by 1 we have 1 bst of 1
	    and for 2 we can arrange using two ways
	    Now idea is simple for rest numbers. for n=3 make 1 as root node so there will be 0 nodes in left subtree and 2 nodes in right subtree. we know the             solution for 2 nodes that they can be used to make 2 bsts.
	    Now making 2 as the root node , there will be 1 in left subtree and 1 node in right subtree. ! node results in 1 way for making a BST.
	    Now making 3 as root node. There will be 2 nodes in left subtree and 0 nodes in right subtree. We know 2 will give 2 BST and zero will give 1 BST.
	    Totalling the result of all the 3 nodes as root will give 5. Same process can be applied for more numbers.
	    
	    */
	    
	    public int numTrees(int n) {
	        //beautiful solution!!!!!!
	        int[] result = new int[n + 1];
	        //store the base cases first
	        if(n == 0  || n == 1)
	            return 1;
	        if(n == 2)
	            return 2;
	        result[0] = 1;
	        result[1] = 1;
	        result[2] = 2;
	        if(n < 3)
	            return result[n];
	        //now start from 3, because we have taken care of 1-2
	        for(int i = 3; i <= n; i++){
	            for(int j = 1; j <= i; j++)
	                result[i] += result[i-j] * result[j-1];
	        }
	        return result[n];
	    }
	}