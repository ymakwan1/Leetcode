class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remCount = new int[60];
        int pairCount = 0;
        
        for(int t : time){
            int remainder = t % 60;
            int complement = (60 - remainder) % 60;
            pairCount += remCount[complement]; 
            remCount[remainder]++;   
        }
        
        return pairCount;
    }
}