class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //Brute
        int[][] ans = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ans[j][n -1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < ans.length; i++) {
            matrix[i] = Arrays.copyOf(ans[i], ans[i].length);
        }

        // for(int row = 0; row < n; row++){
        //     for(int col = row; col < n; col++){
        //         if(row != col){
        //             int temp = 0;
        //             temp = matrix[row][col];
        //             matrix[row][col] = matrix[col][row];
        //             matrix[col][row] = temp;
        //         }
        //     }
        // }

        // for(int row = 0; row < n; row++){
        //     for(int col = 0; col < n/2; col++){
        //         int temp = 0;
        //         temp = matrix[row][col];
        //         matrix[row][col] = matrix[row][n-col-1];
        //         matrix[row][n-col-1] = temp;
        //     }
        // }
    }
}