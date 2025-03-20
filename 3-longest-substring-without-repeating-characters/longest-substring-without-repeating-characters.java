class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int n = s.length();
        //Brute
        int[] hash = new int[256];
        for(int i = 0; i < n; i++){
            Arrays.fill(hash, 0);
            for(int j = i; j < n; j++){
                if(hash[s.charAt(j)] == 1){
                    break;
                }
                maxLen = Math.max(maxLen, j - i + 1);
                hash[s.charAt(j)] = 1;
            }
        }
        return maxLen;
    }
}