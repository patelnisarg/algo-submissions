class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.addFirst(val);

        // doing <= since there could be duplicates
        if(minStack.isEmpty() || val <= minStack.peekFirst()){
            minStack.addFirst(val);
        }
    }

    public void pop() {
        int top = stack.pollFirst();
        if(top == minStack.peekFirst()){
            minStack.pollFirst();
        }
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return minStack.peekFirst();
    }
}
/**
- push - adds to the stack, update the minValues 
- pop - remove from stack, update the minvalue  to the next min if the top of the stack = minvalue 
- top - returns the top element of the stack 
- getMin - return minValue 
*/