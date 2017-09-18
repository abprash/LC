package group.LC;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) { val = x; }
	      
	      public static void inOrder(TreeLinkNode root){
	    	  if(root != null){
	    		  inOrder(root.left);
	    		  System.out.print(root.val+" ");
	    		  inOrder(root.right);
	    	  }
	      }
	  }
	 
public class TreeLinkNodeLauncher {
	
	    public static void main(String[] args){
	    	HashMap<Integer, Integer> l = new HashMap<Integer, Integer>();
	    	Set<Entry<Integer, Integer>> x =  l.entrySet();
	    	 for(Entry<Integer, Integer> e : l.entrySet()){
	                if(e.getValue() < minValue){
	                    minValue = e.getValue();
	                    minKey = e.getKey();
	                }
	    	TreeLinkNode root = new TreeLinkNode(1);
	    	root.left = new TreeLinkNode(2);
	    	root.right = new TreeLinkNode(3);
	    	root.left.left = new TreeLinkNode(4);
	    	root.left.right = new TreeLinkNode(5);
	    	
	    	root.right.left = new TreeLinkNode(6);
	    	root.right.right = new TreeLinkNode(7);
	    	TreeLinkNode.inOrder(root);
	    	new TreeLinkNodeLauncher().connect(root);
	    	System.out.println("\n");
	    	TreeLinkNode.inOrder(root);
	    }
	    
	    
	    //right method
	    public void connect(TreeLinkNode root) {
	        if(root == null)
	            return;
	        if(root.left != null){
	            root.left.next = root.right;
	        if(root.next != null)
	            root.right.next = root.next.left;
	        }
	        connect(root.left);
	        connect(root.right);
	        return;
	    }
	    
	    //*************************the below one does not work************
	    public void connect2DoesNotWork(TreeLinkNode root) {
	        if(root == null)
	            return;
	        if(root.left != null){
	            if(root.right != null)
	                root.left.next = root.right;
	            else if(root.next != null && root.next.left!= null)
	                root.left.next  = root.next.left;
	            else if(root.next != null)
	                root.left.next = root.next.right;
	            }
	        if(root.right != null){
	            if(root.next != null && root.next.left != null)
	                root.right.next = root.next.left;
	            else if(root.next != null )
	                root.right.next = root.next.right;
	        }
	        if(root.next != null){
	            if(root.next.left != null)
	                root.next.left.next = root.next.right;
	        }
	        connect(root.left);
	        connect(root.right);
	    }
	  //****************************************************
	  //****************************************************the below one does work************
	  
	    public void connect(TreeLinkNode root) {
	        if(root == null)
	            return;
	        TreeLinkNode cur = root;
	        while(cur != null){
	            if(cur.left != null){
	                if(cur.right != null)
	                    cur.left.next = cur.right;
	                else
	                    cur.left.next = getNext(cur);
	            }
	            if(cur.right != null){
	                cur.right.next = getNext(cur);
	            }
	            cur = cur.next;
	        }
	        connect(root.left);
	        connect(root.right);
	        
	    }
	    
	    public TreeLinkNode getNext(TreeLinkNode root){
	        TreeLinkNode temp = root.next;
	        while(temp != null){
	            if(temp.left != null)
	                return temp.left;
	            if(temp.right != null)
	                return temp.right;
	            temp = temp.next;
	        }
	        return null;
	    }
	}
	    
	}