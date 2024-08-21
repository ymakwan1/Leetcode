class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        if (n == 0) return 0;

        // dp[i][j] will store the minimum number of turns needed to print the substring s[i:j]
        int[][] dp = new int[n][n];

        // Base case: a single character can be printed in one turn
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill the dp table
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                dp[i][j] = length; // max turns would be the length of the substring
                for (int k = i; k < j; k++) {
                    int totalTurns = dp[i][k] + dp[k + 1][j];
                    if (s.charAt(i) == s.charAt(j)) {
                        totalTurns--; // merge the last characters if they are the same
                    }
                    dp[i][j] = Math.min(dp[i][j], totalTurns);
                }
            }
        }

        // The result is stored in dp[0][n-1], which represents the minimum turns for the entire string
        return dp[0][n - 1];
    }
}
