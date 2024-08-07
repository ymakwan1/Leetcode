class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int currentWidth = 0;
            int maxHeight = 0;
            for (int j = i; j > 0; j--) {
                currentWidth += books[j - 1][0];
                if (currentWidth > shelf_width) break;
                maxHeight = Math.max(maxHeight, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + maxHeight);
            }
        }

        return dp[n];
    }
}
