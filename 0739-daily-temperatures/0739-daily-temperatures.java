class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] resultArray = new int[temperatures.length];
        
        for(int i = 0 ; i < n; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int prev = stack.pop();
                resultArray[prev] = i - prev;
            }
            stack.push(i);
        }
        return resultArray;
    }
}