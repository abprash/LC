package group.LC;

import java.util.LinkedList;
import java.util.ListIterator;

public class JumpGame {
	
	//can jump only once
	//no jump chaining
	
	
    public boolean canJump(int[] nums) {
        //the jump is only once and
        //from one index only
        //its not chaining of jumps
        //goes until the last element
        int reachable = 0;
        for(int i=0; i<nums.length; i++){
            if(i > reachable)
                return false;//we have encountered an element or elements which could not be jumped
            reachable = Math.max(reachable, i+nums[i]);
        }
        
        return true;
    }
    
    public static void main(String[] args){
    	LinkedList<Integer> l = new LinkedList<Integer>();
    	l.add(1);
    	l.add(2);
    	l.add(3);
    	l.add(4);
    	l.add(17);
    	
    	ListIterator<Integer> it =  l.listIterator(l.size());
    	while(it.hasPrevious())
    		System.out.println(it.previous());
    	
    	for(int i=0; true; i++){
    		
    	}
    	float f = 51;
    }
}