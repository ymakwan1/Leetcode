class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();

        for(char c :  s.toCharArray()){
            if(!stack.isEmpty() && stack.peek()[0] == c){
                stack.peek()[1]++;
                if(stack.peek()[1] == k){
                    stack.pop();
                }
            }else{
                stack.push(new int[]{c, 1});
            }
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            int[] top = stack.pop();
            result.append(String.valueOf((char)top[0]).repeat(top[1]));
        }

        return result.reverse().toString();
    }
}