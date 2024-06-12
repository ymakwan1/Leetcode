class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int maxLength = 0;
        int n = nums.length;

        while(right < n){
            if(nums[right] == 0){
                zeroCount++;
            }
            while(zeroCount > 1){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}