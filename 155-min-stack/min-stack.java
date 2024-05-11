class MinStack {
    
    private Stack<Integer> mainStack;
    private Stack<Integer> minValueStack;
    
    public MinStack() {
        mainStack = new Stack<>();
        minValueStack = new Stack<>();
    }
    
    public void push(int val) {
        mainStack.push(val);
        
        if(minValueStack.isEmpty() || val <= minValueStack.peek()){
            minValueStack.push(val);
        }
    }
    
    public void pop() {
        if(!mainStack.isEmpty()){
            if(mainStack.peek().equals(minValueStack.peek())){
                minValueStack.pop();
            }
            mainStack.pop();
        }
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minValueStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */