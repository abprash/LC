package group.LC;

import java.util.Stack;

public class MyQueue {

	
	//********************Queue implementation using stacks
	//done
	
    Stack<Integer> queue = new Stack<Integer>();
    /** Initialize your data structure here. */
    public MyQueue() {
        super();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        //keep a temp stack
        Stack<Integer> stack = new Stack<Integer>();
        while(!queue.empty())
            stack.push(queue.pop());
        stack.push(x);
        while(!stack.empty())
            queue.push(stack.pop());
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return queue.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */