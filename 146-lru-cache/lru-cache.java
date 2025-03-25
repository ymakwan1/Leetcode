class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }

        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }else{
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            
            if(cache.size() > capacity){
                Node removed = removeTail();
                cache.remove(removed.key);
            }
        }
    }

    private void moveToHead(Node node){
        removeNode(node);
        addNode(node);
    }

    private void addNode(Node node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private Node removeTail(){
        Node removed = tail.prev;
        removeNode(removed);
        return removed;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */