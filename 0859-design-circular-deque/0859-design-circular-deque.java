class MyCircularDeque {
    LinkedList list;
    int capacity;
    public MyCircularDeque(int k) {
        list = new LinkedList<Integer>();
        capacity = k;
    }
    
    public boolean insertFront(int value) {
        if(list.size() >= capacity){
            return false;
        }
        list.addFirst(value);
        return true;
    }
    
    public boolean insertLast(int value) {
        if(list.size() >= capacity){
            return false;
        }
        list.addLast(value);
        return true;
    }
    
    public boolean deleteFront() {
        if(list.isEmpty()){
            return false;
        }
        list.removeFirst();
        return true;
    }
    
    public boolean deleteLast() {
        if(list.isEmpty()){
            return false;
        }
        list.removeLast();
        return true;
    }
    
    public int getFront() {
        return list.isEmpty() ? -1 : (int)list.getFirst();
    }
    
    public int getRear() {
        return list.isEmpty() ? -1 : (int) list.getLast();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public boolean isFull() {
        return list.size() == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */