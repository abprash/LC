package group.LC;

import java.util.ArrayList;
import java.util.List;

class MinStack {
    int minimumElement = Integer.MAX_VALUE;
    List<Integer> stack = new ArrayList<Integer>();
    int pointer = -1;
    /** initialize your data structure here. */
    public MinStack() {
        super();
    }
    
    public void push(int x) {
        if(x < minimumElement)
            minimumElement = x;
        stack.add(x);
        pointer++;
    }
    
    public void pop() {
        int element = stack.get(pointer);
        stack.remove(pointer);
        pointer--;
        
        if(element == minimumElement){
            minimumElement = Integer.MAX_VALUE;
            for(int l:stack){
                if(l < minimumElement)
                    minimumElement = l;
            }
        }
        
    }
    
    public int top() {
        return stack.get(pointer);
    }
    
    public int getMin() {
        return minimumElement;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */