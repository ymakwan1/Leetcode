class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        // Calculate the expected sum of first n+1 natural numbers.
        int expectedSum = (n * (n + 1)) / 2;
        
        // Calculate the actual sum of elements in the array.
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        
        // The missing number is the difference between the expected sum and the actual sum.
        return expectedSum - actualSum;
    }
}
