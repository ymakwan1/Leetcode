class Solution {
    public int minimizedStringLength(String s) {
        int[] charArray = new int[26];
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(charArray[s.charAt(i) - 'a'] != 1){
                charArray[s.charAt(i) - 'a']++;
                count++;
            }
        }
        return count;
    }
}