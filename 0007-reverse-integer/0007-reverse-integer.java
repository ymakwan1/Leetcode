class Solution {
    public int reverse(int x) {
        int result = 0;
        boolean isNegative = false;

        if(x < 0){
            isNegative = true;

            if(x == Integer.MIN_VALUE){
                return 0;
            }

            x = Math.abs(x);
        }

        while(x != 0){
            if (result > (Integer.MAX_VALUE - x % 10) / 10) {
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }

        return isNegative ? -result : result;
    }
}