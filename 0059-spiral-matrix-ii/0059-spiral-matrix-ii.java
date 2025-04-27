class Solution {
    public int[][] generateMatrix(int n) {
        List<Integer> result = new ArrayList<>();
        int[][] matrix = new int[n][n];
        int val = 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while(left <= right && top <= bottom){
            for(int i = left; i <= right; i++){
                matrix[top][i] = val;
                val++;
            }
            top++;

            for(int i = top; i <= bottom; i++){
                matrix[i][right] = val;
                val++;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--){
                    matrix[bottom][i] = val;
                    val++;
                }

                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--){
                    matrix[i][left] = val;
                    val++;
                }

                left++;
            }
        }
        return matrix;
    }
}