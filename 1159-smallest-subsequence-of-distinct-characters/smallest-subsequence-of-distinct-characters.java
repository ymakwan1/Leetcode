class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        int[] lastOcc = new int[26];
        boolean[] visited = new boolean[26];

        for(int i = 0; i < s.length(); i++){
            lastOcc[s.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(visited[c - 'a']){
                continue;
            }

            while(!stack.isEmpty() && stack.peek() > c && lastOcc[stack.peek() - 'a'] > i){
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            visited[c - 'a'] = true;        
        }

        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}