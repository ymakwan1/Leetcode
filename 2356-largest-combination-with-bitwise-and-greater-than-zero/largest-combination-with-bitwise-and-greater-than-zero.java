class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitCount = new int[32];

        for(int num :  candidates){
            for(int b = 0; b < 32; b++){
                if(((num >> b) & 1) == 1){
                    bitCount[b]++;
                }
            }
        }

        int maxCount = 0;
        for(int count : bitCount){
            if(count > maxCount){
                maxCount = count;
            }
        }

        return maxCount;
    }
}