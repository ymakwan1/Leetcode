class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flips = 0;
        int flipCount = 0;
        int[] flip = new int[n];

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                flipCount -= flip[i-k];
            }

            if ((nums[i] + flipCount) % 2 == 0) {
                if (i+k > n) {
                    return -1; // can't flip k bits
                }
                flipCount++;
                flips++;
                flip[i] = 1; // Mark the start of a flip
            }
        }

        return flips;
    }
}