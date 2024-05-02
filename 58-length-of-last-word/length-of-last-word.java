class Solution {
    public int lengthOfLastWord(String s) {
     
        s=s.trim();
        String strArray[] = s.split(" ");
        
        return strArray[strArray.length - 1].length();
    }
}