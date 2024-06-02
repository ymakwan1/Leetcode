class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for(int i = 0; i < heights.length - 1; i++){
            int diff = heights[i+1] - heights[i];
            if(diff > 0){
                if(ladders > 0){
                    ladders--;
                    minHeap.add(diff);
                } else if(!minHeap.isEmpty() && diff > minHeap.peek() && minHeap.peek() <= bricks){
                    int smallestDiff = minHeap.poll();
                    bricks -= smallestDiff;
                    minHeap.add(diff);
                } else if(diff <= bricks){
                    bricks -= diff;
                } else{
                    return i;
                }
            }
        }

        return heights.length - 1;
    }
}