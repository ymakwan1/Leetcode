class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;

        if(n <= 4){
            return 0;
        }

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        minDiff = Math.min(nums[n-1] - nums[3], minDiff); // Change first 3 small elems
        minDiff = Math.min(nums[n-2] - nums[2], minDiff); // Change 2 small & 1 large
        minDiff = Math.min(nums[n-3] - nums[1], minDiff); // Change 2 large & 1 small
        minDiff = Math.min(nums[n-4] - nums[0], minDiff); // Change first 3 large elems

        return minDiff;
    }
}