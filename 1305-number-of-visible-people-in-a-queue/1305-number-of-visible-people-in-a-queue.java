class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n-1; i >= 0; i--) {
            int count = 0;
            while(!stack.isEmpty() && stack.peek() <= heights[i]){
                stack.pop();
                count++;
            }
            
            if (!stack.isEmpty()) {
                count++;
            }

            result[i] = count;
            stack.push(heights[i]);
        }

        return result;
    }
}