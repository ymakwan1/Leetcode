class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        // Total chalks available
        long chalkSum = 0;
        for(int c : chalk){
            chalkSum += c;
        }

        // Reduce to remainder
        k %= chalkSum;

        for(int i = 0; i < chalk.length; i++){
            // If more than available, return
            if(chalk[i] > k){
                return i;
            }
            // Subtract in each round
            k -= chalk[i];
        }

        // If no student found
        return -1;
    }
}