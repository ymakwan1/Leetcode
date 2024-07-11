class Solution {
    public String reverseParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch != ')') {
                stack.push(ch);
            } else {
                
                Deque<Character> queue = new ArrayDeque<>();
                while (stack.peek() != '(') {
                    queue.add(stack.pop());
                }
                
                stack.pop();
               
                while (!queue.isEmpty()) {
                    stack.push(queue.poll());
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.removeLast());
        }

        return result.toString();
    }
}