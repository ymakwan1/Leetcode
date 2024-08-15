class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);  // Sort the array to use two pointers
        int n = nums.length;
        int left = 0;
        int right = nums[n - 1] - nums[0];  // Maximum possible distance

        while (left < right) {
            int mid = left + (right - left) / 2;  // Midpoint of the current search range
            int count = 0;  // Number of pairs with distance <= mid

            int j = 0;
            for (int i = 0; i < n; i++) {
                while (j < n && nums[j] - nums[i] <= mid) {
                    j++;
                }
                count += j - i - 1;
            }

            if (count < k) {
                left = mid + 1;  // Increase the lower bound if not enough pairs
            } else {
                right = mid;  // Otherwise, decrease the upper bound
            }
        }

        return left;  // The smallest distance with at least k pairs
    }
}
