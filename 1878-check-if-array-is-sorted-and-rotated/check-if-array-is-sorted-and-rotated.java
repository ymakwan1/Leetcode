public class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        boolean rotated = false;
        
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                
                if (rotated) return false;
                rotated = true;
            }
        }
        
        if (rotated && nums[n - 1] > nums[0]) {
            return false;
        }
        
        return true;
    }
}
