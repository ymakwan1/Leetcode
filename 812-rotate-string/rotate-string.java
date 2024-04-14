class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
            return false;

        String str = s + s;
        //System.out.println(str);
        if(str.contains(goal)){
            return true;
        }
        return false;
    }
}