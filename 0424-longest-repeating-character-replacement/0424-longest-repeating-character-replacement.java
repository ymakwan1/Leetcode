class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] hash = new int[26];
        int l = 0;
        int r = 0;
        int maxF = 0;
        int maxLen = 0;

        while(r < n){
            hash[s.charAt(r) - 'A']++;
            maxF = Math.max(maxF, hash[s.charAt(r) - 'A']);

            if((r - l + 1) - maxF > k){
                hash[s.charAt(l) - 'A']--;
                maxF = 0;
                l++;
            }
            if((r - l + 1) - maxF <= k){
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }

        return maxLen;
    }
}