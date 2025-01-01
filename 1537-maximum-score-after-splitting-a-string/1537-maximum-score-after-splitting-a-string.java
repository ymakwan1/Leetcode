class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int totalOnes = 0;
        int leftZeros = 0;
        int rightOnes = 0;
        int maxScore = 0;

        for(char c : s.toCharArray()){
            if(c == '1'){
                totalOnes++;
            }
        }

        rightOnes = totalOnes;

        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == '0'){
                leftZeros++;
            }else{
                rightOnes--;
            }
            maxScore = Math.max(maxScore, leftZeros + rightOnes);
        }

        return maxScore;
    }
}