class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() > prices[i]){
                stack.pop();
            }

            result[i] = prices[i] - (stack.isEmpty() ? 0 : stack.peek());

            stack.push(prices[i]);
        }

        return result;
    }
}