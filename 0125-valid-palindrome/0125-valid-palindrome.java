class Solution {
    public boolean isPalindrome(String s) {
        String result = s.replaceAll("[^a-zA-Z0-9]", "");
        result = result.toLowerCase();
        char[] charArray = result.toCharArray();
        int len = charArray.length-1;
        for(int i = 0; i <= len ; i++) {
            if (charArray[i]==charArray[len-i]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}