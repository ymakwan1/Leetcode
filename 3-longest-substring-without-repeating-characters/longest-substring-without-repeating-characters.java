class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int n = s.length();
        int[] hash = new int[256];
        //Brute
        // for(int i = 0; i < n; i++){
        //     Arrays.fill(hash, 0);
        //     for(int j = i; j < n; j++){
        //         if(hash[s.charAt(j)] == 1){
        //             break;
        //         }
        //         maxLen = Math.max(maxLen, j - i + 1);
        //         hash[s.charAt(j)] = 1;
        //     }
        // }

        //Optimal
        int  l = 0, r = 0;
        Arrays.fill(hash, -1);
        while(r < n){
            if(hash[s.charAt(r)] != -1){
                if(hash[s.charAt(r)] >= l){
                    l = hash[s.charAt(r)] + 1;
                }
            }
            maxLen = Math.max(maxLen, r - l + 1);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxLen;
    }
}