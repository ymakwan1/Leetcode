class Solution {
    public int subsetXORSum(int[] nums) {
        return subsetXORSumHelper(nums, 0, 0);
    }

    private int subsetXORSumHelper(int[] nums, int index, int currentXOR) {
        if (index == nums.length) {
            return currentXOR;
        }

        // Include the current element in the subset
        int include = subsetXORSumHelper(nums, index + 1, currentXOR ^ nums[index]);

        // Exclude the current element from the subset
        int exclude = subsetXORSumHelper(nums, index + 1, currentXOR);

        // Return the sum of both cases
        return include + exclude;
    }
}
