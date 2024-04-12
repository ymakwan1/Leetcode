class Solution {
    public String removeOuterParentheses(String s) {
        int bracketCount = 0;
        StringBuilder str = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c == '('){
                if(bracketCount > 0){
                    str.append(c);
                }
                bracketCount++;
            }else if (c == ')'){
                bracketCount--;
                if(bracketCount > 0){
                    str.append(c);
                }
            }
        }

        return str.toString();
    }
}