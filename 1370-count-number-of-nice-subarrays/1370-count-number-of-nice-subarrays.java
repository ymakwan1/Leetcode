class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }

    private int helper(int[] nums, int goal){
        if(goal < 0){
            return 0;
        }

        int n = nums.length;
        int count = 0;
        int left = 0;
        int right = 0;
        int sum = 0;

        while(right < n){
            sum += nums[right] % 2;

            while(sum > goal){
                sum -= nums[left] % 2;
                left++;
            }

            count += (right - left + 1);
            right++;
        }

        return count;
    }
}