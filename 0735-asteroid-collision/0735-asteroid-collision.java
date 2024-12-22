class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;
        
        for(int i = 0; i < n; i++){
            boolean destroyed = false;
            while(!stack.isEmpty() && asteroids[i] < 0 && 0 < stack.peek()){
                if(Math.abs(stack.peek()) < Math.abs(asteroids[i])){
                    stack.pop();
                }else if(Math.abs(stack.peek()) == Math.abs(asteroids[i])){
                    destroyed = true;
                    stack.pop();
                    break;
                }else{
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed){
                stack.push(asteroids[i]);
            }
        }

        int[] ans = new int[stack.size()];
        int i = stack.size() - 1;
        while(!stack.isEmpty()){
            ans[i] = stack.pop();
            i--;
        }
        return ans;
    }
}