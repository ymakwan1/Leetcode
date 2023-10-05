import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> repeatNumberStack = new Stack<Integer>();
        Stack<String> stack = new Stack<String>();
        String decodedString = "";
        int currentRepeatNumber = 0;
        
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                currentRepeatNumber = currentRepeatNumber * 10 + (c - '0');
            } else if(c == '['){
                repeatNumberStack.push(currentRepeatNumber);
                currentRepeatNumber = 0;
                stack.push(decodedString);
                decodedString = "";
            }
            else if(c == ']'){
                int repeat = repeatNumberStack.pop();
                String repString = stack.pop();

                for (int i = 0; i < repeat; i++) {
                    repString += decodedString;
                }
                decodedString = repString;
            }
            else {
                decodedString += String.valueOf(c);
            }
        }
        return decodedString;
    }
}