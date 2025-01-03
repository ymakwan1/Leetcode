class Solution {
    public int waysToSplitArray(int[] nums) {
        long totalSum = 0;
        for(int n : nums){
            totalSum += n;
        }
        int count = 0;
        long leftSum = 0;

        for(int i = 0; i < nums.length-1; i++){
            leftSum += nums[i];
            long rightSum = totalSum - leftSum;

            if(leftSum >= rightSum){
                count++;
            }
        }

        return count;
    }
}