class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int[] count = new int[32];
        int start = 0, end = 0, min = nums.length + 1;

        while (end < nums.length) {
            updateBits(count, nums[end], 1);
            while (start <= end && getVal(count) >= k) {
                min = Math.min(min, end - start + 1);
                updateBits(count, nums[start], -1);
                start++;
            }
            end++;
        }
        return min == nums.length + 1 ? -1 : min;
    }

    private void updateBits(int[] count, int num, int val) {
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                count[i] += val;
            }
        }
    }

    private int getVal(int[] count) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (count[i] > 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}