class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] result = new int[n];

        int mask = (int) Math.pow(2, maximumBit) - 1;
        
        int cumulativeXOR = 0;
        for(int num : nums){
            cumulativeXOR ^= num;
        }

        for(int i = 0; i < n; i++){
            result[i] = cumulativeXOR ^ mask;
            cumulativeXOR ^= nums[n - 1 - i];
        }

        return result;
    }
}