class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        if(k >= num.length()){
            return "0";
        }

        for(char n : num.toCharArray()){
            while(!stack.isEmpty() && k > 0 && stack.peek() > n){
                stack.pop();
                k--;
            }
            stack.push(n);
        }

        while(k > 0){
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.insert(0, stack.pop());
        }

        while(result.length() > 1 && result.charAt(0) == '0'){
            result.deleteCharAt(0);
        }

        return result.toString();
    }
}