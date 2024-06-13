class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }

    private int helper(int[] nums, int k){
        int n = nums.length;
        int count = 0;
        int left = 0;
        int[] hash = new int[n + 1];
        int distinctCount = 0;

        for (int right = 0; right < n; right++) {
            if (hash[nums[right]] == 0) {
                distinctCount++;
            }
            hash[nums[right]]++;

            while (distinctCount > k) {
                hash[nums[left]]--;
                if (hash[nums[left]] == 0) {
                    distinctCount--;
                }
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}