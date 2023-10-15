class MRUQueue {
    int[] mruQueue;
    public MRUQueue(int n) {
        mruQueue = new int[n];
        for(int i = 0; i < n; i++){
            mruQueue[i] = i+1;
        }
    }
    
    public int fetch(int k) {
        int index = k-1;
        int element = mruQueue[index];
        for(int i=index; i < mruQueue.length - 1; i++){
            mruQueue[i] = mruQueue[i+1];
        }
        mruQueue[mruQueue.length - 1] = element;
        return element;
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */