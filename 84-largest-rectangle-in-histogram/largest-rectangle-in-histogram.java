class Solution {
    public int largestRectangleArea(int[] heights) {
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