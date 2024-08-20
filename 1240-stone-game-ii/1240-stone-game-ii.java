class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        
        // dp[i][M] represents the maximum number of stones Alex can get 
        // starting from index i with M
        int[][] dp = new int[n][n + 1];

        // Suffix sum to calculate the total stones left starting from index i
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        // Fill the dp table using memoization
        for (int i = n - 1; i >= 0; i--) {
            for (int M = 1; M <= n; M++) {
                // If you can take all the remaining piles
                if (i + 2 * M >= n) {
                    dp[i][M] = suffixSum[i];
                } else {
                    for (int x = 1; x <= 2 * M; x++) {
                        dp[i][M] = Math.max(dp[i][M], suffixSum[i] - dp[i + x][Math.max(M, x)]);
                    }
                }
            }
        }

        return dp[0][1];
    }
}
