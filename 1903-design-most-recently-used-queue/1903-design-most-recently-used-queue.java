class MRUQueue {
    LinkedList<Integer> linkedList;
    public MRUQueue(int n) {
        linkedList = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            linkedList.add(i);
        }
    }
    
    public int fetch(int k) {
        int toReturn = linkedList.get(k-1);
        linkedList.remove(k-1);
        linkedList.add(linkedList.size(), toReturn);
        // for(int i = 0; i < linkedList.size(); i++){
        //     System.out.println(linkedList.get(i));
        // }
        return toReturn;
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */