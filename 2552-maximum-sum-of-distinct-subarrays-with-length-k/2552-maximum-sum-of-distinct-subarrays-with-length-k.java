class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if(k > n){
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        long currentSum = 0;
        long maxSum = 0;
        int start = 0;

        for(int end = 0; end < n; end++){
            //Shrink ig duplicates in subarray
            while(set.contains(nums[end])){
                set.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }

            //Add current elem to window
            set.add(nums[end]);
            currentSum += nums[end];
            
            //Check if window size is k
            if(end - start + 1 == k){
                maxSum = Math.max(currentSum, maxSum);

                //Slide winddow from left
                set.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }
        }

        return maxSum;
    }
}