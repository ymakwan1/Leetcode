class Solution {
    public int characterReplacement(String s, int k) {
        
        int start = 0;
        int maxLength = 0;
        int maxCount = 0;
        
        int[] charArray = new int[26];
        
        for(int end = 0; end < s.length(); end++){
            charArray[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, charArray[s.charAt(end) - 'A']);
            
            if(end - start + 1 - maxCount > k){
                charArray[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}