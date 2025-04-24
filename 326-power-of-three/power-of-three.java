class Solution {
    public boolean isPowerOfThree(int n) {
        //Brute multiply and check
        // if(n < 1){
        //     return false;
        // }
        // long power = 1;
        // while(power < n){
        //     power *= 3;
        // }

        // return power == n;

        //Better - divide by 3 repeatedly
        if(n < 1){
            return false;
        }
        while(n % 3 == 0){
            n /= 3;
        }

        return n == 1;
    }
}