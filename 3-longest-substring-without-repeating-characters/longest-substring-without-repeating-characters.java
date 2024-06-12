class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int[] hash = new int[256];
        int n = s.length();

        while(right < n){
            while(hash[s.charAt(right)] == 1){
                hash[s.charAt(left)]--;
                left++;
            }
            hash[s.charAt(right)]++;
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}