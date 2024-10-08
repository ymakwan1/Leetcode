class Solution {
    // Memoization map to store results
    private Map<String, List<Integer>> memo = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String expression) {
        // Check if the result for the current expression is already computed
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> result = new ArrayList<>();
        
        // Traverse the expression to find operators to divide the expression
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            // If the character is an operator, divide the expression
            if (c == '+' || c == '-' || c == '*') {
                // Recursively calculate left and right parts
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                // Combine results from left and right sub-expressions based on the operator
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') {
                            result.add(l + r);
                        } else if (c == '-') {
                            result.add(l - r);
                        } else if (c == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }
        
        // If the expression contains only a number, add it to the result list
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        
        // Store the result in the memo map
        memo.put(expression, result);
        
        return result;
    }
}
