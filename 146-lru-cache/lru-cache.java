class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> cache;
    private final Deque<Integer> accessOrder;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.accessOrder = new ArrayDeque<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        
        //Move key to most recently used position
        accessOrder.remove(key);
        accessOrder.addLast(key);

        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            accessOrder.remove(key);
        }else if(cache.size() == capacity){
            //Remove LRU elem from front of queue
            int lruKey = accessOrder.pollFirst();
            cache.remove(lruKey);
        }
        cache.put(key, value);
        accessOrder.addLast(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */