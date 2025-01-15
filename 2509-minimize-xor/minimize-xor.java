class Solution {
    public int minimizeXor(int num1, int num2) {
        int countOnes = Integer.bitCount(num2);
        int result = 0;

        for(int i = 31; i >=0 && countOnes > 0; i--){
            if((num1 & (1 << i)) != 0){
                result |= (1 << i);
                countOnes--;
            }
        }   

        for(int i = 0; i <= 31 && countOnes > 0; i++){
            if((result & (1 << i)) == 0){
                result |= (1 << i);
                countOnes--;
            }
        }    

        return result;
    }
}