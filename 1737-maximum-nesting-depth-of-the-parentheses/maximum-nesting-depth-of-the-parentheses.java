class Solution {
    public int maxDepth(String s) {
        if(s.length() == 0 || s.length() == 1 || !s.contains("(")){
            return 0;
        } 

        int maxDepth = Integer.MIN_VALUE;
        int depth = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                depth++;
            }else if (c == ')'){
                maxDepth = Math.max(maxDepth, depth);
                depth--;
            }
        }

        return maxDepth;
    }
}