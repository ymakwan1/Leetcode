class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for(int i=0; i < rows; i++){
            for(int j= i+1;j<cols;j++){
                if(i != j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        
        for(int r = 0; r < rows; r++){
            int start = 0;
            int end = matrix[r].length-1;
            
            while(start<=end){
                int t = matrix[r][start];
                matrix[r][start] = matrix[r][end];
                matrix[r][end] = t;
                
                start++;
                end--;
            }
        }
    }
}