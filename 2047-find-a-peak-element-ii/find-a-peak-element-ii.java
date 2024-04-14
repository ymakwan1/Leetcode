class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int left = 0;
        int right = n - 1;

        // Binary search on columns
        while (left <= right) {
            int midCol = left + (right - left) / 2;
            
            // Find the row index of the maximum element in the middle column
            int maxRow = 0;
            for (int i = 0; i < m; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }
            
            // Check if the maximum element is a peak or if there is a greater neighbor
            if ((midCol == 0 || mat[maxRow][midCol] > mat[maxRow][midCol - 1]) &&
                (midCol == n - 1 || mat[maxRow][midCol] > mat[maxRow][midCol + 1]) &&
                (maxRow == 0 || mat[maxRow][midCol] > mat[maxRow - 1][midCol]) &&
                (maxRow == m - 1 || mat[maxRow][midCol] > mat[maxRow + 1][midCol])) {
                return new int[]{maxRow, midCol}; // Found a peak element
            } else if ((midCol > 0 && mat[maxRow][midCol - 1] > mat[maxRow][midCol])) {
                right = midCol - 1; // Search in the left half of the columns
            } else {
                left = midCol + 1; // Search in the right half of the columns
            }
        }
        
        return new int[]{-1, -1}; // No peak element found
    }
}
