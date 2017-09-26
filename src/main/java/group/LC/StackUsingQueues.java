package group.LC;

public class StackUsingQueues {
    Queue<Integer> queue = new LinkedList<>();
    int lastAdded = Integer.MAX_VALUE;
    /** Initialize your data structure here. */
    public MyStack() {
        super();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        //update lastAdded
        lastAdded = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //put all elements into a temp queue
        Queue<Integer> tempQueue = new LinkedList<>();
        while(queue.size() > 1)
            tempQueue.add(queue.remove());
        //if the queue size reaches 1
        //then remove that element
        int del = queue.remove();
        //put the elements back into the stack
        while(tempQueue.size() > 0){
            if(tempQueue.size() == 1)
                lastAdded = tempQueue.peek();
            queue.add(tempQueue.remove());
        }
        //return that element
        return del;
    }
    
    /** Get the top element. */
    public int top() {
        return lastAdded;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size()==0 ;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
