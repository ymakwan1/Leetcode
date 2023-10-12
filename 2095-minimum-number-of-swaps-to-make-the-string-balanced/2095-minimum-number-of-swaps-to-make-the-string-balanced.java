class Solution {
    public int minSwaps(String s) {
        int start = 0;
        int end = s.length() - 1;
        int openBracket = 0;
        int closeBracket = 0;

        for(char c : s.toCharArray()){
            if(c == '['){
                openBracket++;
            }
            else if(c == ']' && openBracket > 0){
                openBracket--;
            }else {
                closeBracket++;
            }
        }

        return (closeBracket + 1)/2;
    }
}