class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        int currSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                currSum += nums[i];
            }else{
                maxSum = Math.max(maxSum, currSum);
                currSum = nums[i];
            }
        }

        maxSum = Math.max(maxSum, currSum);

        return maxSum;
    }
}