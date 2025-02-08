class NumberContainers {
    private Map<Integer, Integer> indexToNumber;  
    private Map<Integer, PriorityQueue<Integer>> numberToIndices;  

    public NumberContainers() {
        indexToNumber = new HashMap<>();
        numberToIndices = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexToNumber.containsKey(index)) {
            int oldNumber = indexToNumber.get(index);
            if (oldNumber != number) {
                numberToIndices.get(oldNumber).remove(index);
            }
        }
        
        indexToNumber.put(index, number);
        numberToIndices.putIfAbsent(number, new PriorityQueue<>());
        numberToIndices.get(number).add(index);
    }

    public int find(int number) {
        if (!numberToIndices.containsKey(number) || numberToIndices.get(number).isEmpty()) {
            return -1;
        }
        
        PriorityQueue<Integer> minHeap = numberToIndices.get(number);
        
        while (!minHeap.isEmpty()) {
            int smallestIndex = minHeap.peek();
            if (indexToNumber.get(smallestIndex) == number) {
                return smallestIndex;
            }
            minHeap.poll();
        }
        
        return -1;
    }
}


/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */