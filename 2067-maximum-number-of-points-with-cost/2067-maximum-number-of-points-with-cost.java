class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;

        // DP array to store the maximum points for each column in the current row
        long[] dp = new long[n];

        // Initialize dp with the first row's points
        for (int j=0; j < n; j++) {
            dp[j] = points[0][j];
        }

        // Iterate over each row starting from the second row
        for (int i=1; i < m; i++) {
            // Left to right pass to calculate maximum points with leftward transitions
            long[] leftMax = new long[n];
            leftMax[0] = dp[0];

            for (int j=1; j < n; j++) {
                leftMax[j] = Math.max(leftMax[j - 1] - 1, dp[j]);
            }

            // Right to left pass to calculate maximum points with rightward transitions
            long[] rightMax = new long[n];
            rightMax[n - 1] = dp[n - 1];
            for (int j= n - 2; j >= 0; j--) {
                rightMax[j] = Math.max(rightMax[j + 1] - 1, dp[j]);
            }

            // Update dp array for the current row
            for (int j=0; j < n; j++) {
                dp[j] = points[i][j] + Math.max(leftMax[j], rightMax[j]);
            }
        }

        // The maximum value in the dp array is the result
        long maxPoints = 0;
        for (int j=0; j < n; j++) {
            maxPoints = Math.max(maxPoints, dp[j]);
        }

        return maxPoints;
    }
}
