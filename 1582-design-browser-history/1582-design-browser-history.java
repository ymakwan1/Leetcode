class BrowserHistory {
    Stack<String> backStack;
    Stack<String> forwardStack;
    String currentUrl;
    public BrowserHistory(String homepage) {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        currentUrl = homepage;
    }
    
    public void visit(String url) {
        backStack.push(currentUrl);
        currentUrl = url;
        while(!forwardStack.isEmpty()){
            forwardStack.pop();
        }
    }
    
    public String back(int steps) {
        int count = 0;
        while(!backStack.isEmpty() && count < steps){
            forwardStack.push(currentUrl);
            currentUrl = backStack.pop();
            count++;
        }
        return currentUrl;
    }
    
    public String forward(int steps) {
        int count = 0;
        while(!forwardStack.isEmpty() && count < steps){
            backStack.push(currentUrl);
            currentUrl = forwardStack.pop();
            count++;
        }
        return currentUrl;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */