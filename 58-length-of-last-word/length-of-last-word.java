class Solution {
    public int lengthOfLastWord(String s) {
        char[] c = s.toCharArray();
        s=s.trim();
        String strArray[] = s.split(" ");
        for(String st : strArray){
            //System.out.println(st);
        }
        System.out.println(strArray[strArray.length - 1].length());
       // System.out.println(s.split(" "));
        return strArray[strArray.length - 1].length();
    }
}