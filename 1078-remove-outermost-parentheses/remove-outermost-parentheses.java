class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '('){
                if(!stack.isEmpty()){
                    str.append(c);
                }
                stack.push(c);
            }
            else if(c == ')'){
                stack.pop();
                if(!stack.isEmpty()){
                    str.append(c);
                }
            }
        }
        return str.toString();
    }
}