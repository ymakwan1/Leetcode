class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int index = 0;

        // Directions
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int steps = 1;
        int d = 0;

        // Initial direction
        result[index++] = new int[]{rStart, cStart}; 

        while(index < rows * cols){
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < steps; j++){
                    rStart += dr[d];
                    cStart += dc[d];

                    // Boundary checks
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        result[index++] = new int[]{rStart, cStart};
                    }
                }
                // Bound to 4 directions
                d = (d+1) % 4; 
            }
            steps++;
        }

        return result;
    }
}