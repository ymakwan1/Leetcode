class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;

        for(int i = 0; i < n; i++){
            if(i > maxIndex){
                return false;
            }

            maxIndex = Math.max(maxIndex, i + nums[i]);

            if(maxIndex > n){
                break;
            }
        }

        return true;
    }
}