class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return countPaths(0, 0, m, n, dp);
    }

    private int countPaths(int i, int j, int m, int n, int[][] dp) {
        // Base cases
        if (i == m - 1 && j == n - 1) {
            return 1; // Reached the bottom-right corner
        }
        if (i >= m || j >= n) {
            return 0; // Out of bounds
        }
        if (dp[i][j] != 0) {
            return dp[i][j]; // Already calculated
        }
        
        // Calculate the number of unique paths recursively
        dp[i][j] = countPaths(i + 1, j, m, n, dp) + countPaths(i, j + 1, m , n, dp);
        return dp[i][j];
    }
}
