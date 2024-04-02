class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int count = 1; // Count of unique elements
        int start = 0; // Pointer for non-duplicate elements
        
        for (int end = 1; end < nums.length; end++) {
            if (nums[start] != nums[end]) {
                count++; // Increment count for unique elements
                start++; // Move to the next non-duplicate element
                nums[start] = nums[end]; // Update the non-duplicate element
            }
            // If nums[start] == nums[end], it's a duplicate, so we move to the next element
        }
        
        return count;
    }
}
