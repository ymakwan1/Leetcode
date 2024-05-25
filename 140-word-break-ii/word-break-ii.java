class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // List to set
        Set<String> wordSet = new HashSet<>(wordDict);

        // Memo map
        HashMap<Integer, List<String>> memo = new HashMap<>();

        return wordHelper(s, wordSet, 0, memo);
    }

    private List<String> wordHelper(String s, Set<String> wordSet, int start, HashMap<Integer, List<String>> memo){
        // Already compute check
        if(memo.containsKey(start)){
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();

        if(start == s.length()){
            result.add("");
            return result;
        }

        for(int end = start + 1; end <= s.length(); end++){
            String prefix = s.substring(start, end);

            // if prefix in word set
            if(wordSet.contains(prefix)){
                List<String> suffixes = wordHelper(s, wordSet, end, memo);

                // Combine the prefix with suffix
                for(String suffix : suffixes){
                    result.add(prefix + (suffix.isEmpty() ? "" : " ") + suffix);
                }
            }
        }

        // Store the result for this starting index in the memoization map
        memo.put(start, result);
        return result;
    }
}