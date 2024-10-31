class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        //Sort robots and factories 
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        int r = robot.size();
        int f = factory.length;

        long[][] dp = new long[f + 1][r + 1];

        //Initialize with large vals
        for(long[] row : dp){
            Arrays.fill(row, Long.MAX_VALUE / 2);
        }

        //no robot so zero dist
        for (int i = 0; i <= f; i++) {
            dp[i][0] = 0;
        }

        //populate
        for(int i = 1; i <= f; i++){
            for(int j = 1; j <= r; j++){
                dp[i][j] = dp[i - 1][j];
                long cumulativeDist = 0;
                for (int k = 1; k <= factory[i - 1][1] && j - k >= 0; k++) {
                    cumulativeDist += Math.abs(robot.get(j - k) - factory[i - 1][0]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k] + cumulativeDist);
                }
            }
        }

        return dp[f][r];
    }
}