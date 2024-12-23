class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;
        int[][] prefixSum = new int[n][m];

        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == '0') {
                    sum = 0;
                } else {
                    sum += matrix[i][j] - '0';
                }
                prefixSum[i][j] = sum;
            }
        }

        for(int i = 0; i < n; i++){
            maxArea = Math.max(maxArea, largestRectangleArea(prefixSum[i]));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                int elem = stack.peek();
                stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();

                maxArea = Math.max(heights[elem] * (nse - pse - 1), maxArea);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int elem = stack.pop();
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();

            maxArea = Math.max(heights[elem] * (nse - pse - 1), maxArea);
        }


        return maxArea;
    }
}