class Solution {
    public void moveZeroes(int[] nums) {
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] != 0) {
                nums[start] = nums[end];
                if (start != end) {
                    nums[end] = 0; 
                }
                start++;
            }
        }
    }
}