class Solution {
    public int minSteps(String s, String t) {
        int[] freqS = new int[26];
        int[] freqT = new int[26];

        for(char c : s.toCharArray()){
            freqS[c-'a']++;
        }


        for(char c : t.toCharArray()){
            freqT[c-'a']++;
        }

        int minStep = 0;
        for(int i = 0; i < 26; i++){
            minStep += Math.abs(freqT[i]-freqS[i]);
        }

        return minStep/2;
    }
}