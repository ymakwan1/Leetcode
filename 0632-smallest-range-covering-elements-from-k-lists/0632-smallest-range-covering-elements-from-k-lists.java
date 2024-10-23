class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        //Maintain smallest from each list
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int max = Integer.MIN_VALUE;
        int start = 0, end = Integer.MAX_VALUE;

        //Heapify the first element of each list
        for(int i = 0; i < nums.size(); i++){
            int num = nums.get(i).get(0);
            pq.offer(new int[]{num, i, 0}); //value, index of list, index of element in list
            max = Math.max(num, max);
        }

        while(pq.size() == nums.size()){
            int[] curr = pq.poll();
            int min = curr[0];
            int listIndex = curr[1];
            int elementIndex = curr[2];

            //Update range if smaller range found
            if(max - min < end - start){
                start = min;
                end = max;
            }

            //Push next element from list into heap
            if(elementIndex + 1 < nums.get(listIndex).size()){
                int nextElement = nums.get(listIndex).get(elementIndex + 1);
                pq.offer(new int[]{nextElement, listIndex, elementIndex+1});
                max = Math.max(nextElement, max);
            }
        }

        return new int[]{start, end};
    }
}