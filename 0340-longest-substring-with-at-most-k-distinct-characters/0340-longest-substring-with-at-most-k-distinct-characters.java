class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLen = 0;
        int[] hash = new int[256];
        int left = 0;
        int right = 0;
        int n = s.length();
        int uniqueCount = 0;

        while(right < n){

            if(hash[s.charAt(right)] == 0){
                uniqueCount++;
            }
            hash[s.charAt(right)]++;

            while (uniqueCount > k) {
                hash[s.charAt(left)]--;
                if (hash[s.charAt(left)] == 0) {
                    uniqueCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}