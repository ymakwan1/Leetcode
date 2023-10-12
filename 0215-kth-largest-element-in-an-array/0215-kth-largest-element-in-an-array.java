class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums);
        // return nums[nums.length - k];

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i = 0; i < k; i++){
            pq.offer(nums[i]);
        }

        for(int i = k ; i < nums.length; i++){

            int current = nums[i];
            int max = pq.peek();

            if(current > max){
                pq.poll();
                pq.offer(current);
            }
        }

        return pq.peek();
    }
}