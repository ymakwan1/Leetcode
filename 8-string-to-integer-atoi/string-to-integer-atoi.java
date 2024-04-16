class Solution {
    public int myAtoi(String s) {
        StringBuilder str = new StringBuilder();

        if(s == null || s.isEmpty()){
            return 0;
        }

        int sign = 1;
        long result = 0;
        int n = s.length();
        int index = 0;

        //Handle whitespace
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        //handling sign
        if(index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')){
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        //Go through numbers
        while(index < n && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index) - '0';
            result = result * 10 + digit;

            //Overflow check
            if(result > Integer.MAX_VALUE){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            index++;
        }

        return (int) (result * sign);
    }
}