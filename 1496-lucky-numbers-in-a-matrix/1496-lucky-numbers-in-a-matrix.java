class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        int[] rowMin = new int[matrix.length];
        int[] minColIndex = new int[matrix.length];
        
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int colIndex = -1;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    colIndex = j;
                }
            }
            rowMin[i] = min;
            minColIndex[i] = colIndex;
        }
        
        for (int i = 0; i < rowMin.length; i++) {
            int col = minColIndex[i];
            int value = rowMin[i];
            boolean isMax = true;
            
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][col] > value) {
                    isMax = false;
                    break;
                }
            }
            
            if (isMax) {
                result.add(value);
            }
        }
        
        return result;
    }
}