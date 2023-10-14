class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        Set<String> wordSet = new HashSet<>(wordDict);
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(wordSet.contains(s.substring(j,i)) && dp[j] == true){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}