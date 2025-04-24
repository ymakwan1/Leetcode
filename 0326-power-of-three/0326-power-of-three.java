class Solution {
    public boolean isPowerOfThree(int n) {
        //Brute multiply and check
        if(n < 1){
            return false;
        }
        long power = 1;
        while(power < n){
            power *= 3;
        }

        return power == n;
    }
}