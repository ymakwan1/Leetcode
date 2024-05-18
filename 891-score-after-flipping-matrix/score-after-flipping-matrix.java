class Solution {
    public int matrixScore(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0; i < row; i++){
            if(grid[i][0] == 0){
                flipRow(grid, i);
            }
        }

        for(int i = 1; i < col; i++){
            int count1 = 0;
            for(int j = 0; j < row; j++){
                if(grid[j][i] == 1){
                    count1++;
                }
            }
            if (count1 <= row / 2) {
                flipColumns(grid, i);
            }
        }

        int score = 0;
        for(int i = 0; i < row; i++){
            int rowValue = 0;
            for(int j = 0; j < col; j++){
                rowValue = (rowValue << 1) + grid[i][j];
            }
            score += rowValue;
        }

        return score;
    }

    private void flipRow(int[][] grid, int i){
        for(int j = 0; j < grid[0].length; j++){
            grid[i][j] = 1 - grid[i][j];
        }
    }

    private void flipColumns(int[][] grid, int i){
        for(int j = 0; j < grid.length; j++){
            grid[j][i] = 1 - grid[j][i];
        }
    }
}