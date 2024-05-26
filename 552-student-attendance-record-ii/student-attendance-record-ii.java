class Solution {
    public int checkRecord(int n) {
        int MOD = 1_000_000_007;

        int[][][] dp = new int[n+1][2][3];

        dp[0][0][0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= 1; j++){
                for(int k = 0; k <= 2; k++){
                    // Add P
                    dp[i][j][0] = (dp[i][j][0] + dp[i-1][j][k]) % MOD;

                    // Add A
                    if(j > 0){
                        dp[i][j][0] = (dp[i][j][0] + dp[i-1][j-1][k]) % MOD;
                    }

                    //Add L
                    if(k > 0){
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                    }
                }
            }
        }

        // Sum up the result
        int result = 0;
        for(int j = 0; j <= 1; j++){
            for(int k = 0; k <= 2; k++){
                result = (result + dp[n][j][k]) % MOD;
            }
        }

        return result;
    }
}