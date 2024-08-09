class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        
        // Iterate over each possible starting point for a 3x3 grid
        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[0].length - 3; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean isMagicSquare(int[][] grid, int r, int c) {
        // Check for numbers 1 to 9
        boolean[] seen = new boolean[10];
        
        // Check if the grid contains all numbers from 1 to 9 exactly once
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[r + i][c + j];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }
        
        int sum1 = grid[r][c] + grid[r][c + 1] + grid[r][c + 2]; // first row sum
        int sum2 = grid[r + 1][c] + grid[r + 1][c + 1] + grid[r + 1][c + 2]; // second row sum
        int sum3 = grid[r + 2][c] + grid[r + 2][c + 1] + grid[r + 2][c + 2]; // third row sum
        
        if (sum1 != sum2 || sum2 != sum3) {
            return false;
        }
        
        int sum4 = grid[r][c] + grid[r + 1][c] + grid[r + 2][c]; // first column sum
        int sum5 = grid[r][c + 1] + grid[r + 1][c + 1] + grid[r + 2][c + 1]; // second column sum
        int sum6 = grid[r][c + 2] + grid[r + 1][c + 2] + grid[r + 2][c + 2]; // third column sum
        
        if (sum1 != sum4 || sum4 != sum5 || sum5 != sum6) {
            return false;
        }
        
        int diag1 = grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2]; // diagonal from top-left to bottom-right
        int diag2 = grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c]; // diagonal from top-right to bottom-left
        
        return sum1 == diag1 && diag1 == diag2;
    }
}
