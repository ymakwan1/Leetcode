class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n - 2][n - 2];

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int maxValue = Integer.MIN_VALUE;
                // Iterate over the 3x3 submatrix centered at (i, j)
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        maxValue = Math.max(maxValue, grid[k][l]);
                    }
                }
                // Store the maximum value in maxLocal
                maxLocal[i - 1][j - 1] = maxValue;
            }
        }
        return maxLocal;
    }
}