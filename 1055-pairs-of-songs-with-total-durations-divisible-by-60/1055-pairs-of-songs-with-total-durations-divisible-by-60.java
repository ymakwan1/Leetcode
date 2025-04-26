class Solution {
    public int numPairsDivisibleBy60(int[] time) {
       long[] songs = new long[60];

        for(int t : time){
            songs[t % 60]++;
        }

        int pairs = 0;
        for(int i = 1 ; i < 30 ; i++){
            pairs += songs[i] * songs[60-i];
        }
        pairs += (songs[0] * (songs[0]-1)) / 2;
        pairs += (songs[30] * (songs[30]-1)) / 2;
        return pairs;
    }
}