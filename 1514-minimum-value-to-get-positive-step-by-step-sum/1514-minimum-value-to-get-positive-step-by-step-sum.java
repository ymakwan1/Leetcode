class Solution {
    public int minStartValue(int[] nums) {
        int prefixSum = 0, minPrefixSum = 0;

        for(int n : nums){
            prefixSum += n;
            minPrefixSum = Math.min(prefixSum, minPrefixSum);
        }

        return 1 - minPrefixSum;
    }
}