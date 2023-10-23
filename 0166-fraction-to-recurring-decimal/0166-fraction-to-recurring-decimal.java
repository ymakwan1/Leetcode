class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<>();

        if(numerator == 0){
            return "0";
        }

        if((numerator < 0) ^ (denominator < 0)){
            result.append("-");
        }

        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        result.append(String.valueOf(num/den));

        long remainder = num%den;

        if(remainder == 0){
            return result.toString();
        }

        result.append(".");

        while(remainder != 0){
            if(map.containsKey(remainder)){
                int index = map.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            }

            map.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }
        return result.toString();
    }
}