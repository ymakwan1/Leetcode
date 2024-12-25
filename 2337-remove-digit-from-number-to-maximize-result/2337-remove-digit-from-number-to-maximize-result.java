class Solution {
    public String removeDigit(String number, char digit) {
        String maxResult = "";
        int n = number.length();

        for(int i  = 0; i < n; i++){
            if(number.charAt(i) == digit){
                String newNumber = number.substring(0, i) + number.substring(i+1);
                if(newNumber.compareTo(maxResult) > 0){
                    maxResult = newNumber;
                }
            }
        }

        return maxResult;
    }
}