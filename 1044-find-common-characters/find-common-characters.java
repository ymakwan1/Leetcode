class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int[] refFreq = new int[26];

        for(char c : words[0].toCharArray()){
            refFreq[c - 'a']++;
        }

        for(int i = 1; i < words.length; i++){
            int[] currFreq = new int[26];
            for(char c : words[i].toCharArray()){
                currFreq[c - 'a']++;
            }

            for(int j = 0; j < 26; j++){
                refFreq[j] = Math.min(refFreq[j], currFreq[j]);
            }
        }
        
        for (int i = 0; i < 26; i++) {
            while (refFreq[i] > 0) {
                result.add(String.valueOf((char) (i + 'a')));
                refFreq[i]--;
            }
        }

        return result;
    }
}