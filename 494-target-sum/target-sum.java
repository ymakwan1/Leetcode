class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }

        if((target + totalSum) % 2 != 0 || target > totalSum || target < -totalSum){
            return 0;
        }

        int sumP = (target + totalSum) / 2;
        int[] dp = new int[sumP + 1];
        dp[0] = 1;

        for(int num : nums){
            for(int j = sumP; j >= num; j--){
                dp[j] += dp[j - num];
            }
        }

        return dp[sumP];
    }
}