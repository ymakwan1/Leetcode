class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalSum = mean * (m + n);
        int currentSum = 0;

        for(int roll : rolls){
            currentSum += roll;
        }

        int missingSum = totalSum - currentSum;

        if(missingSum < n || missingSum > 6 * n){
            return new int[0];
        }

        int[] result = new int[n];
        int avg = missingSum / n;
        int remainder = missingSum % n;

        for(int i = 0; i < n; i++){
            result[i] = avg + (i < remainder ? 1 : 0);
        }

        return result;
    }
}