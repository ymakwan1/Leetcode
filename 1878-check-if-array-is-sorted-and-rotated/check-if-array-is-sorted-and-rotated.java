public class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        boolean rotated = false;
        
        // Find the breaking point where rotation occurs
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                // If breaking point is not the only point where nums[i] < nums[i-1], return false
                if (rotated) return false;
                rotated = true;
            }
        }
        
        // Check wrap-around condition if rotated
        if (rotated && nums[n - 1] > nums[0]) {
            return false;
        }
        
        return true;
    }
}
