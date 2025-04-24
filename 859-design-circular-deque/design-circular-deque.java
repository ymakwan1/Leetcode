class MyCircularDeque {
    private class Node{
        int val;
        Node prev, next;
        Node(int valIn){
            val = valIn;
        }
    }

    private Node head, tail;
    private int size, capacity;

    public MyCircularDeque(int k) {
        size = 0;
        capacity = k;

        head = new Node(-1);
        tail = new Node(-1);

        head.next = tail;
        tail.prev = head;
    }

    private void addAfter(Node prev, Node node){
        Node next = prev.next;
        prev.next = node;
        node.prev = prev;
        node.next = next;
        next.prev = node;
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        addAfter(head, new Node(value));
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        addAfter(tail.prev, new Node(value));
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        remove(head.next);
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        remove(tail.prev);
        size--;
        return true;
    }
    
    public int getFront() {
        return head.next.val;
    }
    
    public int getRear() {
        return tail.prev.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
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