class MinStack {
    Deque<Integer> stack;
    Map<Integer, Integer> map; // key -> num, value -> freq
    PriorityQueue<Integer> minHeap;

    public MinStack(){
        stack = new ArrayDeque<>();
        map = new HashMap<>();
        minHeap = new PriorityQueue<>();
    }

    private void updateHeap(){
        while(!minHeap.isEmpty() && map.getOrDefault(minHeap.peek(), 0) == 0){
            minHeap.poll();
        }
    }

    public void push(int val) {
        stack.addFirst(val);
        map.put(val, map.getOrDefault(val, 0)+1);
        minHeap.add(val);
        updateHeap();
    }
    
    public void pop() {
        if(stack.isEmpty()){ throw new Error("Unable to pop, Stack is Empty"); }
        int numRemoved = stack.removeFirst();
        if(map.getOrDefault(numRemoved, 0) > 0){
            map.put(numRemoved, map.get(numRemoved)-1);
        }
        updateHeap();
    }
    
    public int top() {
        if(stack.isEmpty()){ throw new Error("Stack is Empty"); }
        return stack.peekFirst();

    }
    
    public int getMin() {
        updateHeap();
        return minHeap.peek();
    }
}
