class Solution {
    public boolean rotateString(String s, String goal) {

        //Check if length same, or else cannot be rotated
        if(s.length() != goal.length())
            return false;

        //Concate s with itself
        String str = s + s;
        
        //Check if goal is substring
        if(str.contains(goal)){
            return true;
        }
        return false;
    }
}