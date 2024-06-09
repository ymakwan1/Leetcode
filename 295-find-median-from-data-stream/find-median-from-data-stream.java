class MedianFinder {
    //Store small half of numbers
    private PriorityQueue<Integer> maxHeap;

    //Store larger half of numbers
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        // Move large elem from maxHeap to minHeap
        minHeap.offer(maxHeap.poll());

        // Balance heaps
        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        // if maxheap has more, then return root;
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }

        // heaps are equal size, return average of roots
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */