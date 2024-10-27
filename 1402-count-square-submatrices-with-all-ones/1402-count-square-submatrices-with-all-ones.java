class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int count = 0;

        int[][] dp = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(matrix[i][j] == 1){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                    count += dp[i][j];
                }
            }
        }

        return count;
    }
}