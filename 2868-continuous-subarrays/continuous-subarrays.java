class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int maxVal = nums[0];
        int minVal = nums[0];
        int start = 0;
        long count = 0;

        for(int end = 0; end < n; end++){
            minVal = Math.min(minVal, nums[end]);
            maxVal = Math.max(maxVal, nums[end]);

            while(maxVal - minVal > 2){
                start++;
                minVal = Integer.MAX_VALUE;
                maxVal = Integer.MIN_VALUE;

                for(int i = start; i <= end; i++){
                    minVal = Math.min(minVal, nums[i]);
                    maxVal = Math.max(maxVal, nums[i]);
                }
            }
            count += end - start + 1;
        }
        return count;
    }
}