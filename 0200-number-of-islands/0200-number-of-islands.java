class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int noOfIslands = 0;
        boolean[][] visitedpoint = new boolean[rows][cols];
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == '1' && !visitedpoint[r][c]){
                    noOfIslands++;
                    dfs(grid,visitedpoint,r,c);
                }
            }
        }
        return noOfIslands;
    }
    
    public void dfs(char[][] grid, boolean[][] visitedpoint, int r, int c){
        int rows = grid.length;
        int cols = grid[0].length;
        Stack<int[]> stack = new Stack<>();
        
        stack.push(new int[]{r,c});
        visitedpoint[r][c] = true;
        
        while(!stack.isEmpty()){
            int[] cell = stack.pop();
            
            int row = cell[0];
            int col = cell[1];
            
            int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
            
            for(int[] d : directions){
                int nrow = row + d[0];
                int ncol = col + d[1];
                
                if(nrow >= 0 && nrow < rows && ncol >=0 && ncol < cols && grid[nrow][ncol] == '1' && !visitedpoint[nrow][ncol]){
                    stack.push(new int[]{nrow,ncol});
                    visitedpoint[nrow][ncol] = true;
                }
            }
        }
    }
}