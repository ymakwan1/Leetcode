class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<Character>();
        StringBuilder result = new StringBuilder();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty()){
                if(stack.peek() == c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
            else{
                stack.push(c);
            }

        }

        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}