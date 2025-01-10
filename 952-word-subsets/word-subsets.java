class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();

        int[] maxFreq = new int[26];
        for(String word : words2){
            int[] freq = countFrequency(word);
            for(int i = 0; i < 26; i++){
                maxFreq[i] = Math.max(freq[i], maxFreq[i]);
            }
        }

        for(String word : words1){
            int[] freq = countFrequency(word);
            if(isUniversal(freq, maxFreq)){
                result.add(word);
            }
        }

        return result;
    }

    private int[] countFrequency(String word){
        int[] freq = new int[26];
        for(char c : word.toCharArray()){
            freq[c - 'a']++;
        }
        return freq;
    }

    private boolean isUniversal(int[] freq, int[] maxFreq){
        for(int i = 0; i < 26; i++){
            if(freq[i] < maxFreq[i]){
                return false;
            }
        }
        return true;
    }
}